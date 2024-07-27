import java.util.*;
class lc516 // Longest Palindromic Subsequence
{
	// Tabulation Approach
	int findLongest1(String s, String t)
	{
		int dp[][] = new int[s.length()+1][s.length()+1];

        for(int i=0; i<=s.length(); i++)
        {
        	dp[0][i]=0;
        	dp[i][0]=0;
        }

        for(int i=1; i<=s.length(); i++)
        {
        	for(int j=1; j<=s.length(); j++)
        	{
        		if(s.charAt(i-1)==t.charAt(j-1))
        			dp[i][j]=1+dp[i-1][j-1];
        		else 
        			dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
        	}
        }
        return dp[s.length()][s.length()];
	}

	// Space Optimization
	int findLongest(String s, String t)
	{
		int dp[] = new int[s.length()+1];

        Arrays.fill(dp, 0);

        for(int i=1; i<=s.length(); i++)
        {
        	int curr[] = new int[s.length()+1];
        	for(int j=0; j<=s.length(); j++)
        	{
        		if(j==0)
        			curr[j]=0;
        		else {
	        		if(s.charAt(i-1)==t.charAt(j-1))
	        			curr[j]=1+dp[j-1];
	        		else 
	        			curr[j] = Math.max(curr[j-1], dp[j]);
        		}
        	}
        	dp = Arrays.copyOf(curr, curr.length);
        }
        return dp[s.length()];
	}
	public int longestPalindromeSubseq(String s) {
		
		// Same as longest common subsequence
		// For palindrome use two strings
		// String 1 : Original String
		// String 2 : Reverse of String 1
        String rev = new StringBuilder(s).reverse().toString(); 

        return findLongest(s, rev);
    }
}