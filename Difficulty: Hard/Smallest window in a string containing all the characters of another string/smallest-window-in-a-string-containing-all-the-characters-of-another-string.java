//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution {
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "-1";  // No possible window if s is smaller than p
        }
        
        // Frequency map for characters in p
        Map<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        
        // Sliding window pointers and other variables
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int count = 0;  // Counts how many characters from p are matched in the current window
        
        Map<Character, Integer> windowMap = new HashMap<>();
        
        // Start sliding the right pointer
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // Include rightChar in the window
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);
            
            // If rightChar is a part of p and its count in the window is less than or equal to the required count in p, increase the match count
            if (pMap.containsKey(rightChar) && windowMap.get(rightChar).intValue() <= pMap.get(rightChar).intValue()) {
                count++;
            }
            
            // Once all characters of p are matched in the current window, try to shrink the window
            while (count == p.length()) {
                // Update the minimum length window if found
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                
                // Now, try to reduce the window size by moving the left pointer
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                
                // If the character at the left is part of p and its count in the window is less than required, decrease the match count
                if (pMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < pMap.get(leftChar).intValue()) {
                    count--;
                }
                
                // Move the left pointer to shrink the window
                left++;
            }
            
            // Expand the window by moving the right pointer
            right++;
        }
        
        // If no valid window was found, return -1
        if (minLength == Integer.MAX_VALUE) {
            return "-1";
        }
        
        // Return the minimum window substring
        return s.substring(minStart, minStart + minLength);
    }
}