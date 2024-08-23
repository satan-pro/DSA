import java.util.*;
class gfgfRodCutting  // Rod Cutting
{
	// Memoization Approach
	int findMax(int i, int j, int price[], int dp[][])
	{
		if(i<0 || j<0)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];

		int notPick = findMax(i-1, j, price, dp);
		int pick=0;
		if(j>=i+1)
			pick = price[i] + findMax(i, j-(i+1), price, dp);
		
		return dp[i][j] = Math.max(pick, notPick);
	}
	public int cutRod(int price[], int n) {
        //code here
		int dp[][] = new int[n][n+1];

		for(int arr[] : dp)
			Arrays.fill(arr, -1);

		int res = findMax(n-1, n, price, dp);
		return res;
    }
}