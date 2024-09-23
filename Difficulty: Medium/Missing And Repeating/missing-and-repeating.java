//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        long sum = 0, sumOfSquares = 0;
        long expectedSum = n * (n + 1L) / 2;
        long expectedSumOfSquares = n * (n + 1L) * (2 * n + 1L) / 6;
        for (int num : arr) {
            sum += num;
            sumOfSquares += (long) num * num;
        }
        long sumDifference = expectedSum - sum;
        long squareSumDifference = expectedSumOfSquares - sumOfSquares;
        long sumOfAPlusB = squareSumDifference / sumDifference;
        int A = (int) (sumDifference + sumOfAPlusB) / 2;
        int B = (int) (sumOfAPlusB - A);
        return new int[] {B, A};
    }
}