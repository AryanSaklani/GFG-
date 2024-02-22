//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/
class Solution
{

int  subsequenceCount(String s, String t)
    {
        int[]prev = new int[t.length()+1];
        prev[0] = 1;
        for(int i = 1; i<=s.length();i++){
            int[]curr = new int[t.length()+1];
            curr[0] = 1;
            for(int j = 1; j<=t.length();j++){
                 int notPick = prev[j]%1000000007;
                 int pick = 0;
                 if(s.charAt(i-1) == t.charAt(j-1)){
                    pick = prev[j-1]%1000000007;
                 }
                 curr[j] = (notPick + pick)%1000000007;
            }
            prev = curr;
        }
        return prev[t.length()];
    }

}