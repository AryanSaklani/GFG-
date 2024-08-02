//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
        int a=str1.length();
        int b=str2.length();
        int ac[][]=new int[a+1][b+1];
        for(int i=0;i<=a;i++) ac[i][0]=i;
        
        for(int j=0;j<=b;j++) ac[0][j]=j;
        
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    ac[i][j]=ac[i-1][j-1];
                }else{
                    ac[i][j]=1+Math.min(Math.min(ac[i][j-1],ac[i-1][j]),ac[i-1][j-1]);
                }
            }
        }
        return ac[a][b];
        
    }
}