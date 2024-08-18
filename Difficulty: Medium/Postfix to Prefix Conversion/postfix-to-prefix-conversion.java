//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String s) {
        // code here
        Stack<String> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
             || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
             || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
            {
                stack.push(String.valueOf(s.charAt(i)));
            }
            else
            {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String st = String.valueOf(s.charAt(i)) + op1 + op2;
                stack.push(st);
            }
        }
        
        return stack.pop();
    }
}
