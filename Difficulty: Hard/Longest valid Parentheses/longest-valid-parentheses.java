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
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static class Pair{
        char ch;
        int idx;
        Pair(char ch,int idx){
            this.ch = ch;
            this.idx = idx;
        }
    }
    static int maxLength(String S){
    Stack<Pair> st = new Stack<>();
    for(int i = 0;i<S.length();i++){
        char c = S.charAt(i);
        if(c == '('){
            st.push(new Pair(c,i));
        }else{
            if(st.size() == 0){
                st.push(new Pair(c,i));
            }
           else if(st.peek().ch == '('){
                st.pop();
            }
           else{
                st.push(new Pair(c,i));
            }
        }
    }
    if(st.size() == 0){
        return S.length();
    }
    int ans = 0;
    if(st.size() != 0){
    ans = Math.max(S.length()-1-st.peek().idx,ans);
    }
    while(st.size() > 1){
       Pair n = st.pop();
       Pair p = st.pop();
       ans = Math.max(ans,n.idx-p.idx-1);
       st.push(p);
    }
    ans = Math.max(ans,st.pop().idx);
    return ans;
    
    }
}