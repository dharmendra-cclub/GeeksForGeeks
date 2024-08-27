//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        int carry = 1;
        int carryOut = add(carry, head);
        if(carryOut == 0)
            return head;
        else
        {
             Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
       
    }
    
    public int add(int carry, Node temp)
    {
        
        if(temp.next == null)
        {
            if(temp.data == 9)
            {
                temp.data = 0;
                return 1;
            }
            else
            {
                temp.data = temp.data + 1;
                return 0;
            }
        }
        int c = add(carry, temp.next);
        if(c == 0) return 0;
        if(carry == 1 && temp.data == 9)
        {
            temp.data = 0;
            return 1;
        }
        else
        {
            temp.data = temp.data + carry;
            return 0;
        }
    }
}
