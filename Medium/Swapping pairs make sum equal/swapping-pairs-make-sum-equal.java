//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
         /*we want s2-s1=0
           lt s2-s1=diff;
           not possible to make equal if its odd as only even diff occur on removing
           even+even=even
           odd+odd=even
           say s2-s1=diff=> s2=s1+diff
           we remove a from s1 and b from s2
           s2+a-b=s1-a+b=>diff+2a=2b
           b-a=diff/2
           b=a+diff/2;
           so we binary search for b in the array which is equal to a+diff/2;
       */
        long s1=0,s2=0;
        for(long k:a)s1+=k;
        for(long k:b)s2+=k;
        
        if(s1<s2)
        {   Arrays.sort(b);
            if((s2-s1)%2==1)
            {
                return -1;
            }
            long diff=(s2-s1)/2;
            for(int i=0;i<a.length;i++)
            {
                if(search(a[i]+diff,b,b.length))return 1;
            }
            return -1;
        }else{Arrays.sort(a);
             if((s1-s2)%2==1)
            {
                return -1;
            }
            long diff=(s1-s2)/2;
            for(int i=0;i<b.length;i++)
            {
                if(search(b[i]+diff,a,a.length))return 1;
            }
            return -1;
        }
    }
    private boolean search(long k,long a[],int n)
    {
        int low=0,high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(a[mid]==k)
            {
                return true;
            }
            if(a[mid]>k)
            {
                high=mid-1;
            }else{
                low=mid+1;
            }
        }return false;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends