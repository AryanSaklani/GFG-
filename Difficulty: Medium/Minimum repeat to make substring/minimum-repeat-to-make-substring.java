//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A, B));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRepeats(String s1, String s2) {
        // code here
        for(char ch : s2.toCharArray()){
            if(!s1.contains(Character.toString(ch))) return -1;
        }
        int count =0; 
        String newStr=" ";
        while(newStr.length() <= s2.length()*2){
            count++;
            newStr +=s1;
            if(newStr.contains(s2)) return count;
        }
        return -1;
    }
};

