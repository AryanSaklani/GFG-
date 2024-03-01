//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int count;
    
    
    static int numberSequence(int m, int n)
    {
        count = 0;

        for (int i = 1; i <= m; i++) {
            generateSequences(m, n, i, 1);
        }

        return count;
    }

    static void generateSequences(int m, int n, int current, int position) {
        if (position == n) {
            count++;
            return;
        }

        for (int i = current * 2; i <= m; i++) {
            generateSequences(m, n, i, position + 1);
        }
    }

}