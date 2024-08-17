//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public static int priority(char op)
    {
        switch (op) 
        {
        case '+':
        case '-':
            return 0;
        case '*':
        case '/':
            return 1;
        case '^':
            return 2;
        default:    
             return -1;
        }
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> stack = new Stack<>();
        String st = "";
        for(int i = 0; i < s.length(); i++)
        {
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
             || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
             || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
             {
                st = st + s.charAt(i);
             }
             
             else if(s.charAt(i) == '(' )
                stack.push(s.charAt(i));
            
            else if(s.charAt(i) == ')')
            {   while(!stack.isEmpty() && stack.peek() != '(')
                {
                    st = st + stack.peek();
                    stack.pop(); 
                }
                stack.pop();
            }
            
            else
            {
                while(!stack.isEmpty() && priority(s.charAt(i)) <= priority(stack.peek()))
                {
                    st = st + stack.peek();
                    stack.pop();
                }
                stack.push(s.charAt(i));
            }
        }
        
        while(!stack.isEmpty())
        {
            st = st + stack.peek();
            stack.pop();
        }
        
        return st;
    }
}