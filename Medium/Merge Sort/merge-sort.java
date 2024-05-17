//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends

class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         int a[] = new int[r-l+1];
         int k = m + 1;
         int i = 0;
         int c = l;
         int d = r;
         while(l <= m && k <= r)
         {
             if(arr[l] < arr[k])
             a[i++] = arr[l++];
             else
             a[i++] = arr[k++];
         }
         while(k <= r)
         a[i++] = arr[k++];
         while(l <= m)
         a[i++] = arr[l++];
         
         for(int j = c; j<= d; j++)
         {
             arr[j] = a[j-c];
         }
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l >= r)
        return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
}
