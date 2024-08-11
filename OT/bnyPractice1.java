import java.util.*;
class bnyPractice1
{
	int findMax(int i, int sum, int[] transaction, int[][] dp)
	{
		if(i==0)
		{
			return sum+transaction[i]>=0?1:0;
		}
		if(dp[i][sum]!=-1)
			return dp[i][sum];

		int pick=0, notPick=0;
		if(sum+transaction[i]>=0)
			pick = 1+findMax(i-1, sum+transaction[i], transaction, dp);
		notPick = findMax(i-1, sum, transaction, dp);
		return dp[i][sum] = Math.max(pick, notPick);
	}
	public int maximizeTransactions(int transaction[])
	{
		int sum=0;
		for(int i:transaction)
		{
			if(i>=0)
				sum+=i;
		}
		int dp[][] = new int[transaction.length][sum+1];

		int res = findMax(transaction.length-1, 0, transaction, dp);
		return res;
	}
}