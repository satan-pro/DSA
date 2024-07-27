import java.util.*;
class gfgSubsetSum
{
	// Memoization Approach
	static boolean findSum(int ind, int target, int arr[], int dp[][])
	{
		if(target==0)
			return true;
		if(ind==0)
			return arr[ind]==target;
		if(dp[ind][target]!=-1)
			return dp[ind][target]==0?false:true;

		boolean notPick = findSum(ind-1, target, arr, dp);
		boolean pick = false;

		if(arr[ind]<=target)
			pick = findSum(ind-1, target-arr[ind], arr, dp);

		dp[ind][target]=pick||notPick?1:0;
		return pick||notPick;
	}
	static Boolean isSubsetSum1(int N, int arr[], int sum){
        // code here
        int dp[][] = new int[N][sum+1];

        for(int[] row:dp)
        	Arrays.fill(row,-1);

        boolean res = findSum(N-1, sum, arr, dp);
        return res;
    }

    // Tabulation Approach
    static Boolean isSubsetSum(int N, int arr[], int sum) {

    	boolean dp[][] = new boolean[N][sum+1];
    	dp[0][0] = true;
    
        if(arr[0]<=sum)
    	{
    		dp[0][arr[0]]=true;
    	}
    	
    	for(int i=1; i<N; i++) // Start from 1st row to avoid running into index 0 with sum>target
    	{
    		for(int j=0; j<=sum; j++)
    		{
    			if(j==0)	// Initialize the base cases
    				dp[i][j]=true;
    			else
    			{
    				boolean pick=false, notPick=false;
    				if(i>0)
    					notPick = dp[i-1][j];
    				if(arr[i]<=j && i>0)
    					pick = dp[i-1][j-arr[i]];
    				dp[i][j] = pick||notPick;
    			}
    		}
    	}
    	return dp[N-1][sum];
    }
}