//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        int left = 0, right = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int min = Math.min(a[0], b[0]);
        list.add(min);
        if(a[0] < b[0])
            left = 1;
        else if(a[0] > b[0])
            right = 1;
        else
        {
            left = 1;
            right = 1; 
        }
        
        while(left < a.length && right < b.length)
        {
            if(a[left] < b[right])
            {
                if(a[left] != list.get(list.size() - 1))
                    list.add(a[left]);
                left++;
            }

            else if(a[left] > b[right])
            {
                if(b[right] != list.get(list.size() - 1))
                    list.add(b[right]);
                right++;
            }
                
            else if(a[left] == b[right])
            {
                if(a[left] != list.get(list.size() - 1))
                    list.add(a[left]);
                left++;
                right++;
            }
        }
        
        while(left < a.length)
        {
            if(a[left] != list.get(list.size() - 1))
                list.add(a[left]);
            left++;
        }
            
        while(right < b.length)
        {
            if(b[right] != list.get(list.size() - 1))
                list.add(b[right]);
            right++;
        }
            
        return list;
    }
}
