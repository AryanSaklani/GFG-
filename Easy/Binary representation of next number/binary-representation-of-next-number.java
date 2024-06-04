//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        // code here.
        char sa[]=s.toCharArray();
        int carry=1,j=0;
        for(int i=sa.length-1;i>=0;i--){
            if(sa[i]=='0'){
                carry=0;
                sa[i]='1';
                break;
            }else sa[i]='0';
        }
        s=new String(sa); 
        if(carry==1) s='1'+s; 
        while(j<s.length() && s.charAt(j)=='0') j++;
        s=s.substring(j); 
        return s;
    }
}