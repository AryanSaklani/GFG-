//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void find(List<String> list,String s,String ans,int i){
        if(i == s.length()){
            list.add(ans);
            return;
        }
        char ch = s.charAt(i);
        find(list,s,ans+ch,i+1);
        find(list,s,ans,i+1);
    }
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> list = new ArrayList<>();
        find(list,s,"",0);
        Collections.sort(list);
        list.remove("");
        return list;
    }
}