//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    /**
     * Function to find the sum of contiguous subarray with maximum sum.
     * 
     * @param arr the input array
     * @return the maximum sum of the contiguous subarray
     */
    int maxSubarraySum(int[] arr) {

        // Initialize maxSum to the smallest possible integer value
        int maxSum = Integer.MIN_VALUE;
        
        // Initialize localSum to 0
        int localSum = 0;
        
        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Add the current element to localSum
            localSum += arr[i];
        
            // Update maxSum if localSum is greater than maxSum
            if (localSum > maxSum) {
                maxSum = localSum;
            }
            
            // Reset localSum to 0 if it becomes negative
            if (localSum < 0) {
                localSum = 0;
            }
        }
        
        // Return the maximum sum found
        return maxSum;
    }
}