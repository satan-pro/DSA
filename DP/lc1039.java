import java.util.*;
class lc1039 
{
	public int findMinParts(int i, int j, int[] values, int[][] dp) {
		if(j-i<2)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];

		int mini = Integer.MAX_VALUE;
		for(int k=i+1; k<j; k++)
		{
			int ops = values[i]*values[k]*values[j] + findMinParts(i, k, values, dp) + findMinParts(k, j, values, dp);
			mini = Math.min(mini, ops); 
		}

		return dp[i][j] = mini;

	}
	public int minScoreTriangulation(int[] values) {
		int n = values.length;
        int[][] dp = new int[n+1][n+1];

        for(int arr[]: dp)
        	Arrays.fill(arr, -1);

        int res = findMinParts(0, n-1, values, dp);
        return res;
    }
}