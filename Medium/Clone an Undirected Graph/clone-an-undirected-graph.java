//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class Node{
    int val;
    ArrayList<Node> neighbors;
    public Node(){
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val){
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}

class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }

    static ArrayList<Node> bfs(Node src){
        ArrayList<Node> ans = new ArrayList<>();
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(src);
        visited.add(src);

        while(!q.isEmpty()){
            Node u = q.poll();
            ans.add(u);
            ArrayList<Node> v = u.neighbors;
            for(Node x : v){
                if(!visited.contains(x)){
                    visited.add(x);
                    q.add(x);
                }
            }
        }

        return ans;
    }

    static boolean checkedClone(Node prev, Node new1){
        ArrayList<Node> prevAns = bfs(prev);
        ArrayList<Node> newAns = bfs(new1);
        for(int i = 0; i < prevAns.size(); i++){
            if(prevAns.get(i) == newAns.get(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            Node root = null;
            Node v[] = new Node[n];
            for(int i = 0; i < n; i++) v[i] = new Node(i);
            Solution ob = new Solution();
            for(int i = 0; i < n; i++){
                ArrayList<Node> li = new ArrayList<>();
                String arr[] = sc.nextLine().split(" ");
                for(String s : arr){
                    li.add(v[Integer.parseInt(s)]);
                }
                v[i].neighbors = li;
            }
            ArrayList<Node> prev = bfs(v[0]);
            Node ans = ob.cloneGraph(v[0]);
            ArrayList<Node> now = bfs(ans);
            out.println(checkedClone(v[0], ans) ? "1" :  "0");
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java


/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution{
    Node cloneGraph(Node node){
        HashMap<Integer, Node> hm = new HashMap();
        HashSet<Integer> visited = new HashSet();
        Queue<Node> q = new LinkedList();
        
        //Initial Adding
        q.add(node);
        hm.put(node.val, new Node(node.val, new ArrayList()));
        
        while(!q.isEmpty()){
            // put node in visited
            Node cur = q.remove();
            visited.add(cur.val);
            ArrayList<Node> neighbours = hm.get(cur.val).neighbors ;
            
            // traverse the entire arraylist
            for(Node n : cur.neighbors){
                if( !visited.contains(n.val)){
                    q.add(n);
                    hm.put(n.val,  new Node(n.val, new ArrayList()));   
                }
                neighbours.add(hm.get(n.val));
            }
        }
        return hm.get(node.val);
    }
}