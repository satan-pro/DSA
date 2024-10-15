import java.util.*;
class lc931
{
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
	public int minFallingPathSum(int[][] matrix) {
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
}