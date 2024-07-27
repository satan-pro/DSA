import java.util.*;
class gfgPerfectSum
{
	// Memoization Approach
	int findCount(int ind, int target, int arr[], int[][] dp)
	{
		if(ind==0) {
    		if(target==0 && arr[0]==0) // base case if target is reached and first element of array is 0
    			return 2;
    		else if(target==0 && arr[0]!=0) // base case is target is reached and first elem is not 0
    		    return 1;
    		else if(target==arr[0]) // base case is target not reached but first elem == target
    		    return 1;
    		else 
    		    return 0;
	    }
		if(dp[ind][target]!=-1)
			return dp[ind][target];

		int pick=0, notPick=0;
		notPick = findCount(ind-1, target, arr, dp);

		if(arr[ind]<=target)
			pick = findCount(ind-1, target-arr[ind], arr, dp);
		
		return dp[ind][target]=(pick+notPick)%1000000007;
	}
	public int perfectSum1(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
		int dp[][] = new int[n][sum+1];

		for(int[] row:dp)
			Arrays.fill(row, -1);

		int res = findCount(n-1, sum, arr, dp);
		return sum==0?res+1:res;
	} 

	// Tabulation Approach
	public int perfectSum(int arr[], int n, int sum) {

		int dp[][] = new int[n][sum+1];

		// Create the base cases from the memoization solution
		if(arr[0]==0)
			dp[0][0]=2;
		else 
			dp[0][0]=1;

		if(arr[0]!=0 && arr[0]<=sum)
			dp[0][arr[0]]=1;

		for(int i=1; i<n; i++)
		{
			for(int j=0; j<=sum; j++)
			{
				int pick=0, notPick=0;
				notPick = dp[i-1][j];
				if(arr[i]<=j)
					pick = dp[i-1][j-arr[i]];

				dp[i][j]=(pick+notPick)%1000000007;
			}
		}
		return dp[n-1][sum];
	}
	
}
