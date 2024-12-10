import java.util.*;
class gfgMatrixChainMultiplication
{
	// Memoization Approach
	static int findMinWays(int i, int j, int arr[], int[][] dp) {
		if(i==j)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];

		int minWay = Integer.MAX_VALUE;
		for(int k=i+1; k<=j; k++)
		{
			int ops = arr[i-1]*arr[k]*arr[j] + findMinWays(i, k-1, arr, dp) + findMinWays(k, j, arr, dp);
			minWay = Math.min(minWay, ops);
		}
		return dp[i][j] = minWay;
	}
	static int matrixMultiplication1(int N, int arr[])
    {
        // code here
        int dp[][] = new int[N][N];

        for(int[] a: dp)
        	Arrays.fill(a, -1);

        int res = findMinWays(1, N-1, arr, dp);
        return res;
    }

    // Tabulation Approach
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int dp[][] = new int[N][N];

        for(int[] a: dp)
        	Arrays.fill(a, -1);

        for(int i=1; i<N; i++)
        	dp[i][i] = 0;

        for(int i=N-1; i>=1; i--)
        {
        	for(int j=i+1; j<N; j++)
        	{
        		int mini = Integer.MAX_VALUE;
        		for(int k=i; k<j; k++)
        		{
        			int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
        			mini = Math.min(mini, steps);
        		}
        		dp[i][j] = mini;
        	}
        }

        return dp[1][N-1];
    }
}