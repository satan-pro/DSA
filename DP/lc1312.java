import java.util.*;
class lc1312 // Minimum Insertions to Make String Palindrome
{
	// Memoization Approach
	int findLPS(int i, int j, String s, String t, int[][]dp)
	{
		if(i==0||j==0)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];

		if(s.charAt(i-1)==t.charAt(j-1))
			return dp[i][j] = 1+findLPS(i-1, j-1, s, t, dp);
		else 
			return dp[i][j] = Math.max(findLPS(i-1, j, s, t, dp), findLPS(i, j-1, s, t, dp));

	}
	public int minInsertions1(String s) {
		String rev = new StringBuilder(s).reverse().toString();
        int dp[][] = new int[s.length()+1][s.length()+1];

        for(int[] arr:dp)
        	Arrays.fill(arr, -1);

        // Find the Longest Palindromic Subsequence
        int res = findLPS(s.length(), s.length(), s, rev, dp);

        // The length of the string (n) - LPS will give the min no of insertions to make string palindrome
        return s.length()-res;
    }

    // Tabulation Approach
    public int minInsertions(String s)
    {
    	String rev = new StringBuilder(s).reverse().toString();
    	int dp[][] = new int[s.length()+1][s.length()+1];

    	for(int i=0; i<=s.length(); i++)
    	{
    		for(int j=0; j<=s.length(); j++)
    		{
    			if(i==0 || j==0)
    			{
    				dp[i][j]=0;
    			}
    			else 
    			{
    				if(s.charAt(i-1)==rev.charAt(j-1))
    					dp[i][j] = 1+dp[i-1][j-1];
    				else 
    					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}

    	int LPS = dp[s.length()][s.length()];
    	return s.length()-LPS;
    }
}