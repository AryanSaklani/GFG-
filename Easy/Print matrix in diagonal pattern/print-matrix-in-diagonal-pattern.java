//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] res = new int[n*n];
        boolean flag = false;
        int j = 0;
        for(int row=0; row<n; row++){
            int r = row, c = 0;
            int[] temp = new int[r-c+1];
            int i = 0;
            while(r>=0 && c<n){
                temp[i++] = mat[r--][c++]; 
            }
            if(flag){
                reverse(temp);
                flag = false;
            }
            else flag = true;
            for(int k=0; k<temp.length; k++,j++){
                res[j] = temp[k];
            }
        }
        for(int col=1; col<n; col++){
            int r = n-1, c = col;
            int[] temp = new int[r-c+1];
            int i = 0;
            while(r>=0 && c<n){
                temp[i++] = mat[r--][c++]; 
            }
            if(flag){
                reverse(temp);
                flag = false;
            }
            else flag = true;
            for(int k=0; k<temp.length; k++,j++){
                res[j] = temp[k];
            }
        }
        return res;
    }
    
    private void reverse(int[] arr){
        int s = 0;
        int e = arr.length-1;
        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}