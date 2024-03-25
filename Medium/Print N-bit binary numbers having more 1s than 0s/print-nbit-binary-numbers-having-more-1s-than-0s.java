//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> al = new ArrayList<String>();
        
        rec(al, "1", N, 0, 1);
        
        return al;
        
    }
    
    void rec(ArrayList<String> al, String temp, int N, int n0, int n1){
        
        if(temp.length()>N || n0>n1) return;
        
        if(temp.length()==N){
            if(n1>=n0){
            al.add(temp);
            return;
            }
            else{
                return;
            }
        }
        
        //Since it is given in question to maintain the decreasing order in answer 
        // So our approach is to generate number with only '1's at first
        rec(al, temp+'1', N, n0, n1+1);
        
        // Now removing '1' from last and adding '0' to it and so on
        rec(al, temp+'0', N, n0+1, n1);
        
        
    }
}