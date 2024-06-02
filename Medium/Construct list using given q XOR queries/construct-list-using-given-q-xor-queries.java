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

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int q;
            q = Integer.parseInt(br.readLine());

            int[][] queries = IntMatrix.input(br, q, 2);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.constructList(q, queries);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    
    /**
     * This function constructs and returns a sorted list after performing a series of XOR and insert queries.
     *
     * @param q The number of queries.
     * @param queries A 2D array where each element is a query of the form [type, value].
     *                type 0 means to insert value into the list.
     *                type 1 means to XOR every element in the list with value.
     * @return The sorted list after performing all the given queries.
     */
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        // Initialize an empty list to store the resulting elements
        ArrayList<Integer> list = new ArrayList<>();
        
        // Variable to keep track of cumulative XOR operations
        int xorTillNow = 0;
        
        // Process the queries in reverse order
        for (int i = q - 1; i >= 0; i--) {
            // If the query is of type 1, update the cumulative XOR value
            if (queries[i][0] == 1) {
                xorTillNow ^= queries[i][1];
            } else {
                // If the query is of type 0, insert the value XORed with the cumulative XOR value into the list
                list.add(queries[i][1] ^ xorTillNow);
            }
        }
        
        // Add the cumulative XOR value to the list as the final element
        list.add(xorTillNow);
        
        // Sort the list to get the final sorted order
        Collections.sort(list);
        
        // Return the sorted list
        return list;
    }
}
