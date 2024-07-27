import java.util.*;
class lc322
{
	// Memoization Approach
	int findMin(int ind, int target, int[] coins, int[][] dp)
	{
		if(ind==0)
		{
			// Base Case
			if(target%coins[ind]==0) 
				return target/coins[ind]; // return how many coins are needed
			return (int)Math.pow(10,8);
		}
		if(dp[ind][target]!=-1)
			return dp[ind][target];
		
		int pick=(int)Math.pow(10,8);

		if(coins[ind]<=target)
			pick = 1+findMin(ind, target-coins[ind], coins, dp); // Pick the same coin repeatedly until target becomes less
		int notPick = findMin(ind-1, target, coins, dp); // Do not pick the coin and move on to the next coin

		return dp[ind][target]=Math.min(pick, notPick);
	}

	public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        Arrays.sort(coins);
        
        for(int[] arr:dp)
        	Arrays.fill(arr, -1);

        int res = findMin(coins.length-1, amount, coins, dp);
        if(res>=(int)Math.pow(10, 8)) // If it is a huge integer then no combination is possible so return -1
        	return -1;
        return res;
    }
}