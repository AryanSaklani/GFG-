//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution
{
    public List<Integer> topologicalSort(int k,List<Set<Integer>> al){
        int indeg[]=new int[k];
        for(Set<Integer> a:al) for(int i:a) indeg[i]++;
        Queue<Integer> q=new LinkedList<>();
        List<Integer> res=new ArrayList<>(); 
        for(int i=0;i<k;i++) if(indeg[i]==0) q.add(i); 
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr); 
            for(int i:al.get(curr)){
                indeg[i]--;
                if(indeg[i]==0) q.add(i);
            }
        } 
        return res.size()==k?res:new ArrayList<>();
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        List<Set<Integer>> al=new ArrayList<>();
        for(int i=0;i<K;i++) al.add(new HashSet<>());
        for(int i=0;i<N-1;i++){
            String a=dict[i],b=dict[i+1];
            int sm=Math.min(a.length(),b.length());
            boolean foundDifference=false;
            for(int j=0;j<sm;j++){
                int u=a.charAt(j)-'a',v=b.charAt(j)-'a';
                if(a.charAt(j)!=b.charAt(j)){
                    if(!al.get(u).contains(v)) al.get(u).add(v);
                    foundDifference=true;
                    break;
                }
            }
            if(!foundDifference && a.length()>b.length()) return "";
        }
        List<Integer> sl=topologicalSort(K,al);
        StringBuilder sb=new StringBuilder();
        for(int i:sl) sb.append((char)(i+'a'));
        return sb.toString();
    }
}