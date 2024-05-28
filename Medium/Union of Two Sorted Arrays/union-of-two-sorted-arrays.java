//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}



// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        int a = 0, b = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int firstElement = arr1[0] <= arr2[0] ? arr1[0] : arr2[0];
        list.add(firstElement);
        while(a < n && b < m)
        {
            if(arr1[a] <= arr2[b])
            {
                if(arr1[a] != list.get(list.size() - 1))
                {
                    list.add(arr1[a++]);
                    continue;
                }
                a++;
            }
            else if(arr2[b] <= arr1[a])
            {
                if(arr2[b] != list.get(list.size() - 1))
                {
                    list.add(arr2[b++]);
                    continue;
                }
                b++;
            }
        }
        
        if(a == n)
        {
            while(b < m)
            {
                if(arr2[b] != list.get(list.size() - 1))
                {
                    list.add(arr2[b++]);
                    continue;
                }
                b++;
            }
        }
        
        if(b == m)
        {
            while(a < n )
            {
                if(arr1[a] != list.get(list.size() - 1))
                {
                    list.add(arr1[a++]);
                    continue;
                }
                a++;
            }
        }
        
        return list;
    }
}



