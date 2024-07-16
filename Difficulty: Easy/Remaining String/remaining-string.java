//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char ch = sc.next().charAt(0);
            int count = sc.nextInt();
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution {
    public String printString(String s, char ch, int tar) {
       StringBuilder sb=new StringBuilder();
       int count=0,i=0;
       for(;i<s.length();i++){
           if(count==tar) break;
           if(s.charAt(i)==ch) count++;
       }
       
        sb.append(s.substring(i,s.length()));
       if(sb.length()==s.length() && (count==tar ||count==0)) return "";
       
       return sb.toString();
    }
}