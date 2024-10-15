import java.util.*;
class wk415q2
{
	int findMax(int i, int j, int[] a, int[] b, int[][] dp) {
		if(i<0)
			return 0;
		if(j<0)
			return Integer.MIN_VALUE;
		if(dp[i][j]!=Integer.MIN_VALUE)
			return dp[i][j];

		int notTake = findMax(i, j-1, a, b, dp);
		int take = a[i]*b[j] + findMax(i-1, j-1, a, b, dp);

		dp[i][j] = Math.max(take, notTake);

		return dp[i][j];
	}
	public long maxScore(int[] a, int[] b) {
        int[][] dp = new int[a.length][b.length];

        for(int[] arr: dp)
        	Arrays.fill(arr, Integer.MIN_VALUE);

        int res = findMax(a.length-1, b.length-1, a, b, dp);
        return res;
    }
}