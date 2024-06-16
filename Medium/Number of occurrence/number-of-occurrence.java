//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int l = 0, u = n - 1;
        int upper_bound = n, lower_bound = n;

        //calculating lower bound
        while(l <= u)
        {
            int mid = (l+u)/2;
            if(arr[mid] >= x)
            {
                lower_bound = mid;
                u = mid - 1;
            }

            else
                l = mid + 1;
        }

        //calculating upper bound
        l = 0;
        u = n - 1;
        while(l <= u)
        {
        int mid = (l+u)/2;
        if(arr[mid] > x)
        {
            upper_bound = mid;
            u = mid - 1;
        }

        else
            l = mid + 1;
        }
        
        if(lower_bound == n || arr[lower_bound] != x)
            return 0;

        return  upper_bound - lower_bound;
    }
}