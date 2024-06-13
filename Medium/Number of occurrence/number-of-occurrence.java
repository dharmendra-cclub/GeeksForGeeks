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
        int counter = 0;
        int size = n;
        int l = 0, u = size - 1;
        while(l <= u)
        {
            int mid = (l+u)/2;
            if(x == arr[mid])
            {
                int initial = mid, last = mid + 1;
                while(initial >= 0)
                {
                    if(arr[initial] == x)
                    {
                        counter++;
                        initial--;
                    }
                    else 
                        break;
                }

                while(last < size)
                {
                    if(arr[last] == x)
                    {
                        counter++;
                        last++;
                    }
                    else
                        break;
                }
                break;
            }

            if(x > arr[mid])
                l = mid + 1;
            else
                u = mid - 1;
        }

        return counter;
    }
}