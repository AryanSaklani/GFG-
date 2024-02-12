//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static long sequence(int n){
        long mod = 1000000007;
        long ans = 0;
         long aa = 1;
        for(int i=0; i<n;i++){
           long a =1;
           for(int j = 0; j<=i; j++){
               a *= aa;
               a %=mod;
               aa = aa+1;
           }
           ans += a;
           ans %= mod;
        }
        return ans;
    }
}