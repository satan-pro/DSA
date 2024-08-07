import java.util.*;
class gfgKnapsackWithDuplicateItems
{
	// Intuition : Just like the coin change problem
	// If the weight of the item is less than equal to target add its value to profit and store it in 'pick'
	// Move the index by 1 and store it in 'notPick'
	// Repeat the steps until i reaches -1
	// Store the minimum value of 'pick' and 'notPick' in the dp array

	// Memoization Approach
	static int findProfit(int i, int target, int val[], int wt[], int dp[][])
	{
		if(i<0)
			return 0;
		if(dp[i][target]!=-1)
			return dp[i][target];

		int pick=0, notPick=0;
		if(wt[i]<=target)
			pick = val[i] + findProfit(i, target-wt[i], val, wt, dp);
		notPick = findProfit(i-1, target, val, wt, dp);
		return dp[i][target] = Math.max(pick, notPick);
	}
	static int knapSack1(int N, int W, int val[], int wt[])
    {
        // code here
    	int dp[][] = new int[N][W+1];

    	for(int arr[]:dp)
    		Arrays.fill(arr, -1);

    	int res = findProfit(N-1, W, val, wt, dp);
    	return res;
    }

    // Tabulation Approach
    static int knapSack(int N, int W, int val[], int wt[])
    {
    	int dp[][] = new int[N][W+1];

    	// Base Case Initialization
    	for(int i=0; i<=W; i++)
    	{
    		if(i<=W)  // If weight is valid, then add the total value of the item until weight becomes less than i
    			dp[0][i] = (i/wt[0])*val[0]; 
    	}

    	for(int i=1; i<N; i++)
    	{
    		for(int j=0; j<=W; j++)
    		{
    			int pick=0, notPick=0;
    			if(wt[i]<=j)
    				pick = val[i]+dp[i][j-wt[i]];
    			notPick = dp[i-1][j];
    			dp[i][j] = Math.max(pick, notPick);
    		}
    	}
    	return dp[N-1][W];
    }

}