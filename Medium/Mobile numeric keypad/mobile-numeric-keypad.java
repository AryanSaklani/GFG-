//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public java.math.BigInteger getCount(int n) {
        if (n==1) return java.math.BigInteger.valueOf(10);
        int[][] neighbours = {
            {0,8},
            {1,2,4},
            {2,1,3,5},
            {3,2,6},
            {4,1,5,7},
            {5,2,4,6,8},
            {6,3,5,9},
            {7,4,8},
            {8,5,7,9,0},
            {9,8,6}
        };
        java.math.BigInteger[][] dp = new java.math.BigInteger[n+1][10]; //n+1 for length of sequence & 10 for digits from 0 to 9
        for(int i=0; i<10;i++){
            dp[1][i]= java.math.BigInteger.ONE; //for one digit each digit can have only one sequence
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                dp[i][j]=java.math.BigInteger.ZERO;
                for( int nebr: neighbours[j]){
                    dp[i][j] =dp[i][j].add(dp[i-1][nebr]);
                }
            }
        }
        java.math.BigInteger result =java.math.BigInteger.ZERO;
        for(int i=0;i<10;i++){
            result=result.add(dp[n][i]);
        }
        return result;
    }
}