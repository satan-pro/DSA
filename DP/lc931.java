import java.util.*;
class lc931
{
	// Memoization Approach
	int findPath(int i, int j, int[][] matrix, int dp[][])
	{
        if(j<0 || j>=matrix[0].length)
			return Integer.MAX_VALUE;
		if(i==0)
			return matrix[i][j];
		if(dp[i][j]!=Integer.MIN_VALUE)
			return dp[i][j];

		int right = findPath(i-1, j+1, matrix, dp);
		int left = findPath(i-1, j-1, matrix, dp);
		int up = findPath(i-1, j, matrix, dp);

		return dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
	}
	public int minFallingPathSum1(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];

        for(int[] arr: dp)
            Arrays.fill(arr, Integer.MIN_VALUE);

        int minPath = Integer.MAX_VALUE;
        for(int j=0; j<matrix[0].length; j++)
        {
        	minPath = Math.min(minPath, findPath(matrix.length-1, j, matrix, dp));
        }
        return minPath;
    }

    // Tabulation Code
    public int minFallingPathSum2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];

        for(int i=0; i<n; i++)
            dp[0][i] = matrix[0][i];

        int res = Integer.MAX_VALUE;

        for(int i=1; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int up, left, right;
                up=left=right=Integer.MAX_VALUE;

                if(j>0)
                    left = dp[i-1][j-1];
                if(j<n-1)
                    right = dp[i-1][j+1];
                up = dp[i-1][j];

                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(up, right));
            }
        }

        // Find the minimum path out of all the elemnts in the last row of the matrix
        for(int i=0; i<n; i++)
            res = Math.min(res, dp[m-1][i]);
        return res;
    }

    // Space optimized code
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int[n];

        for(int i=0; i<n; i++)
            dp[i] = matrix[0][i];

        int res = Integer.MAX_VALUE;

        for(int i=1; i<m; i++)
        {
            int temp[] = new int[n];
            for(int j=0; j<n; j++)
            {
                int up, left, right;
                up=left=right=Integer.MAX_VALUE;

                if(j>0)
                    left = dp[j-1];
                if(j<n-1)
                    right = dp[j+1];
                up = dp[j];

                temp[j] = matrix[i][j] + Math.min(left, Math.min(up, right));
            }
            dp = Arrays.copyOf(temp, temp.length);
        }

        for(int i=0; i<n; i++)
            res = Math.min(res, dp[i]);
        return res;
    }
}