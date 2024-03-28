//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class pair{
    int node;
    int wt;
    pair(int _node, int _weight)
    {
        node = _node;
        wt = _weight;
    }
}
class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          ArrayList<ArrayList<pair>> adj = new ArrayList<>();
          
          for(int i=0;i<n;i++)
          {
              adj.add(new ArrayList<>());
          }
          
          for(int i=0;i<m;i++)
          {
              adj.get(edges[i][0]).add(new pair(edges[i][1], edges[i][2]));
              adj.get(edges[i][1]).add(new pair(edges[i][0], edges[i][2]));
          }
          
          int res = Integer.MAX_VALUE;
          int idx = 0;
          for(int i=0;i<n;i++)
          {
              int ans = calc(adj, i, new int[n], distanceThreshold);
              if(ans <= res)
              {
                  res = ans;
                  idx = i;
              }
          }
          
          return idx;
      }
      
      int calc(ArrayList<ArrayList<pair>> adj , int src, int[] dist, int D)
      {
          Queue<Integer> q = new PriorityQueue<>();
          q.add(src);
          for(int i=0;i<dist.length;i++) dist[i] = (int)(1e9);
          dist[src] = 0;
          int c = 0;
          
          while(!q.isEmpty())
          {
              int node = q.remove();
              for(pair p: adj.get(node))
              {
                  if(dist[node] + p.wt < dist[p.node])
                  {
                      dist[p.node] = p.wt + dist[node];
                      q.add(p.node);
                  }
              }
          }
          
          for(int i=0;i<dist.length;i++)
          {
              if(dist[i] <= D) c++;
          }
          
          return c;
      }
}