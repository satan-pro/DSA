import java.util.*;
class lc518 // Coin Change II
{  
	int findCount(int ind, int target, int[] coins, int[][] dp)
	{
		if(ind==0)
		{
			if(target%coins[ind]==0)
				return 1;
			return 0;
		}
		if(dp[ind][target]!=-1)
			return dp[ind][target];

		int take =0;
		if(coins[ind]<=target)
			take = findCount(ind, target-coins[ind], coins, dp);
		int notTake = findCount(ind-1, target, coins, dp);
		return dp[ind][target] = take+notTake;
	}
	public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        Arrays.sort(coins);

        int res = findCount(coins.length-1, amount, coins , dp);
        return res;
    }
}