//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int[] x, int[] y, int M, int N) {
        // code here
        Arrays.sort(y);  // Sort array y for binary search
        
        long count = 0;
        long one = 0, two = 0, threeFour = 0;
        
        // Count occurrences of special values in y
        for (int num : y) {
            if (num == 1) one++;
            else if (num == 2) two++;
            else if (num == 3 || num == 4) threeFour++;
        }
        
        // Process each element in x
        for (int xi : x) {
            if (xi != 1) {
                count += one; // All y > 1
                if (xi == 2) count -= threeFour; // Special case for xi = 2
                if (xi == 3) count += two; // Special case for xi = 3
                
                // Use binary search to count elements in y greater than xi
                int index = findGreaterThan(y, xi);
                count += y.length - index;
            }
        }
        
        return count;
    }

    // Function to find the number of elements in y greater than a given value
    private int findGreaterThan(int[] y, int val) {
        int low = 0, high = y.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (y[mid] <= val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}