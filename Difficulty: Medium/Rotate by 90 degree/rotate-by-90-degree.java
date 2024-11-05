//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class GFG {
    static void rotate(int mat[][]) {
        int m = mat.length, n = mat[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                arr[j][i] = mat[m - 1 - i][j];
            }
        }
        for (int i = 0; i < m; i++){
            mat[i] = arr[i];
        }
    }
    /*
    1 2 3   0,0  0,1  0,2
    4 5 6   1,0  1,1  1,2
    7 8 9   2,0  2,1  2,2
    
    7 4 1   2,0  1,0  0,0
    8 5 2   2,1  1,1  0,1
    9 6 3   2,2  1,2  0,2  
    */
}