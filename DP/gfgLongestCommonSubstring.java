import java.util.*;
class gfgLongestCommonSubstring
{
	// Tabulation Approach
	int longestCommonSubstr1(String S1, String S2, int n, int m){
        // code here
        int dp[][] = new int[n+1][m+1];

        int maxLen=0;
        for(int i=0; i<=n; i++)
        {
        	for(int j=0; j<=m; j++)
        	{
        		if(i==0 || j==0)
        			dp[i][j]=0;
        		else 
        		{
        			if(S1.charAt(i-1)==S2.charAt(j-1)) // If character matches increase length of common substring
        			{
        				int curr = 1+dp[i-1][j-1];
        				dp[i][j]=curr;
        				maxLen = Math.max(maxLen, curr);
        			}
        			else 
        			{
        				dp[i][j]=0; // If character doesnt match, substring length becomes 0; restart with current character
        			}
        		}
        	}
        }
        return maxLen;
    }

    // Space Optimization
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int dp[] = new int[m+1];
        Arrays.fill(dp, 0);

        int maxLen=0;
        for(int i=1; i<=n; i++)
        {
        	int curr[] = new int[m+1];
        	for(int j=0; j<=m; j++)
        	{
        		if(j==0)
        			curr[j]=0;
        		else 
        		{
        			if(S1.charAt(i-1)==S2.charAt(j-1))
        			{
        				curr[j]=1+dp[j-1];
        				maxLen = Math.max(maxLen, curr[j]);
        			}
        			else 
        			{
        				curr[j]=0;
        			}
        		}
        	}
        	dp = Arrays.copyOf(curr, curr.length);
        }
        return maxLen;
    }
}