//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        if(str.length()<26){
            return false;
        }
        int[] arr = new int[26];
        
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a']++;
            }
        }
        
        int swappable = 0;
        int missingCount = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                missingCount++;
            }else{
                swappable+=arr[i]-1;
            }
        }
        
        return k >= missingCount && swappable>=missingCount;
    }
}