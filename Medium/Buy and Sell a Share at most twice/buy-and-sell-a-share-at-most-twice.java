//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        /*int[][][] dp = new int[n][2][3];
        for(int[][] d1:dp) {
            for(int[] d2:d1) {
                Arrays.fill(d2 , -1);
            }
        }*/
        return solveDp2(price);
    }
    public static int solveDp2(int[] price) {
        int[][][] dp = new int[price.length + 1][2][3];
        for(int ind=price.length-1; ind>=0; ind--) {
            for(int buyOrSell=0; buyOrSell<=1; buyOrSell++) {
                for(int k=1; k<=2; k++) {
                    int buy = 0 , sell = 0 , excl = 0;
                    if(k > 0) {
                        if(buyOrSell == 1) {
                            buy = -price[ind] + dp[ind + 1][0][k];
                        }
                        else {
                            sell = price[ind] + dp[ind + 1][1][k - 1];
                        }
                    }
                    excl = dp[ind + 1][buyOrSell][k];
                    dp[ind][buyOrSell][k] = Math.max(buy , Math.max(sell , excl));
                }
            }
        }
        return dp[0][1][2];
    }
    public static int solveDp(int ind , int buyOrSell , int k , int[] price , int[][][] dp) {
        if(ind == price.length) {
            return 0;
        }
        if(dp[ind][buyOrSell][k] != -1) {
            return dp[ind][buyOrSell][k];
        }
        int buy = 0 , sell = 0 , excl = 0;
        if(k > 0) {
            if(buyOrSell == 1) {
                buy = -price[ind] + solveDp(ind + 1 , 0 , k , price , dp);
            }
            else {
                sell = price[ind] + solveDp(ind + 1 , 1 , k - 1 , price , dp);
            }
        }
        excl = solveDp(ind + 1 , buyOrSell , k , price , dp);
        return dp[ind][buyOrSell][k] = Math.max(buy , Math.max(sell , excl));
    }
    public static int solveRec(int ind , int buyOrSell , int k , int[] price) {
        if(ind == price.length) {
            return 0;
        }
        int buy = 0 , sell = 0 , excl = 0;
        if(k > 0) {
            if(buyOrSell == 1) {
                buy = -price[ind] + solveRec(ind + 1 , 0 , k , price);
            }
            else {
                sell = price[ind] + solveRec(ind + 1 , 1 , k - 1 , price);
            }
        }
        excl = solveRec(ind + 1 , buyOrSell , k , price);
        return Math.max(buy , Math.max(sell , excl));
    }
}
        
