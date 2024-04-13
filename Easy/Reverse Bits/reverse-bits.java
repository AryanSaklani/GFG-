//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
        // code here
        int f = 31, l = 0;     // f = first, l = last
        long rev = 0;
        
        while(f > l) {
            if((x & (1L<<f)) != 0) {   // 1<<f mtlb 'f' agar '0' idx m h toh mask m sb '0' honge except that idx  
                rev = rev | (1L<<l);   // yaha pe bhi check 
            }
            if((x & (1L<<l)) != 0) {
                rev = rev | (1L<<f);     // 1L kiyuki long h 
            }
            f--; l++;
        }
        return rev;
    }
};