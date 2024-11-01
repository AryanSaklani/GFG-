//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution 
{
    public void mergesort(Long[]arr,int start,int end) // applying mergesort :) O(nlog n)
    {
        if(start<end)
        {
            int mid=(start+end)/2;
            mergesort(arr,start,mid);
            mergesort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    
    public void merge(Long[] arr,int start,int mid,int end)
    {
        int start1=start,end1=mid,start2=mid+1,end2=end;
        int index;long arr2[]=new long[arr.length];
        
        for(index=start1;(start1<=end1)&&(start2<=end2);index++)
        {
            if(arr[start1]<arr[start2])
            {
                arr2[index]=arr[start1++];  
            }
            else 
            {
                arr2[index]=arr[start2++];
            }
        }
        
        for(;start1<=end1;start1++,index++)
        {
            arr2[index]=arr[start1];
        }
        
        for(;start2<=end2;start2++,index++)
        {
            arr2[index]=arr[start2];
        }
        
        for(index=start;index<=end;index++)
        {
            arr[index]=arr2[index];
        }
    }
    
    
    public long maxSum(Long[] arr) 
    {
        if(arr.length==1)return arr[0];
        if(arr.length==2)return 2*Math.abs(arr[0]-arr[1]);
        mergesort(arr,0,arr.length-1);
        
        long sum=0;
        int n=arr.length;
        
        
        for (int i = 0; i < n / 2; i++) {
            sum += 2 * (arr[n - i - 1] - arr[i]);
        }
        return sum;
        
        
        // code here
    }
}


//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends