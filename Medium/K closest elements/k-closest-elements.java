//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here-
       
        int ans[] = new int[k];
         int j=arr.length-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x) {
                j=i;
                break;
            }
            if(arr[i]>x){
                j=i-1;
                break;
            }
        }

        int m=j+1;

        for(int i=0;i<k;i++){
            if(j>=0 && arr[j]==x) j--;
            if(m<n && arr[m]==x) m++;
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            
            
            if(j>=0)
             left=Math.abs(arr[j]-x);
            if(m<arr.length)
             right = Math.abs(arr[m]-x);
            if(left<right ){
                ans[i]=arr[j--];
                
                
            }
            else if(m<arr.length)
            ans[i]=arr[m++];
            
        }
       
        return ans;
    }
}
