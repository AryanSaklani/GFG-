//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
         String[] ar=sentence.split(" ");
        long ans=-1,max=-5;
        for(int i=0;i<ar.length;i++){
            boolean c=false;
            for(int j=0;j<ar[i].length();j++){
                if(Character.isDigit(ar[i].charAt(j))){
                    if(ar[i].charAt(j)!='9'){
                        c=true;
                    }
                    else{
                        c=false;
                        break;
                    }
                }
            }
            if(c)
                ans=Long.parseLong(ar[i]);
            if(ans>max){
                max=ans;
            }
        }
        return max;
    }
}