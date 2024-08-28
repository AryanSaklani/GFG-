//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        ArrayList<Integer> result=new ArrayList<>();
        HashMap<Integer,Integer> m=new HashMap<>();
         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1]) {
                return b[1] - a[1]; 
            } else {
                return a[0] - b[0]; 
            }
        });
        
        for(int i:arr) m.put(i,m.getOrDefault(i,0)+1);
        for(Map.Entry<Integer,Integer> me:m.entrySet()){
            pq.offer(new int[]{me.getKey(),me.getValue()});
        }   
        
         while(!pq.isEmpty()){
             int[] curr=pq.poll();
            int p=curr[1];
            while(p-->0){
                result.add(curr[0]);
            }
        }
        
        return result;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends