import java.util.*;
class lc1143 // Longest Common Subsequence
{
	// Memoization Approach
	int findLongest(int ind1, int ind2, String text1, String text2, int[][] dp)
	{
		if(ind1==0 || ind2==0) // Shifting of base case 
			return 0;
		if(dp[ind1][ind2]!=-1)
			return dp[ind1][ind2];

		if(text1.charAt(ind1-1)==text2.charAt(ind2-1)) // Shifting of index by 1
			return dp[ind1][ind2] = 1+findLongest(ind1-1, ind2-1, text1, text2, dp);
		else
			return dp[ind1][ind2] = Math.max(findLongest(ind1-1, ind2, text1, text2, dp), findLongest(ind1, ind2-1, text1, text2, dp));
	}
	public int longestCommonSubsequence1(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];

        for(int[] arr: dp)
        	Arrays.fill(arr,-1);

        int res = findLongest(text1.length(), text2.length(), text1, text2, dp);
        return res;
    }

    // Tabulation Approach
    public int longestCommonSubsequence2(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];

        for(int i=0; i<=text1.length(); i++)
        {
        	for(int j=0; j<=text2.length(); j++)
        	{
        		if(i==0 || j==0) // Base Case initilization
        			dp[i][j]=0;
        		else 
        		{
        			// Finding dp[i][j] with shifting of index by 1 (to avoid running into index==-1)
        			dp[i][j] = (text1.charAt(i-1)==text2.charAt(j-1))?1+dp[i-1][j-1]:Math.max(dp[i-1][j], dp[i][j-1]);
        		}
        	}
        }
        return dp[text1.length()][text2.length()];
    }

    // Space Optimization
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[] = new int[text2.length()+1];
        Arrays.fill(dp, 0); // Base Case initlization

        for(int i=1; i<=text1.length(); i++)
        {
        	int curr[] = new int[text2.length()+1];
        	for(int j=0; j<=text2.length(); j++)
        	{
        		if(j==0) // Base Case initilization
        			curr[j]=0;
        		else 
        		{
        			// Finding curr[j] with shifting of index by 1 (to avoid running into index==-1)
        			curr[j] = (text1.charAt(i-1)==text2.charAt(j-1))?1+dp[j-1]:Math.max(dp[j], curr[j-1]);
        		}
        	}
        	dp = Arrays.copyOf(curr, curr.length);
        }
        return dp[text2.length()];
    }

}