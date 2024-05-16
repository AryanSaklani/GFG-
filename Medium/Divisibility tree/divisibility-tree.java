//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    
     int sol;
    public int minimumEdgeRemove(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++)    list.add(new ArrayList<>());
        
        for(int m[]:edges){
            list.get(m[0]).add(m[1]);
            list.get(m[1]).add(m[0]);
        }

 sol=0;
        nodes(1,list,new boolean[n+1]);
        
        return sol;
    }
    
    int nodes(int i,List<List<Integer>> list,boolean vis[]){
        
        vis[i] = true;
        int non=1;
        
        for(Integer nr:list.get(i)){
            
            if(!vis[nr]){
                non+=nodes(nr,list,vis);
            }
        }
        

   if(non%2==0){
            if(i>1) sol++;
            non=0;
        }
        
        return non;
    }

}
