import java.util.*;
class lc64
{
	// Memoization Approach
	int findMinPath(int i, int j, int[][] grid, int[][] dp) {
		if(i==0 && j==0)
			return grid[i][j];
		if(i<0 || j<0)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];

		int left = grid[i][j]+findMinPath(i, j-1, grid, dp);
		int up = grid[i][j] + findMinPath(i-1, j, grid, dp);

		return dp[i][j] = Math.min(left, up);
	}

	 public int minPathSum1(int[][] grid) {
		int dp[][] = new int[grid.length][grid[0].length];

		for(int[] arr : dp)
			Arrays.fill(arr,-1);

		int res = findMinPath(grid.length-1, grid[0].length-1, grid, dp);
		return res;
    }

    // Tabulation Approach
    public int minPathSum2(int[][] grid) {
    	int dp[][] = new int[grid.length][grid[0].length];

    	for(int i=0; i<grid.length; i++)
    	{
    		for(int j=0; j<grid[0].length; j++)
    		{
    			if(i==0 && j==0)
    				dp[i][j]=grid[i][j];
    			else 
    			{
	    			int left=Integer.MAX_VALUE, up=Integer.MAX_VALUE;

	    			if(i>0)
	    				up=grid[i][j]+dp[i-1][j];
	    			if(j>0)
	    				left=grid[i][j]+dp[i][j-1];

	    			dp[i][j]=Math.min(left, up);
    			}
    		}
    	}
    	return dp[grid.length-1][grid[0].length-1];
    }

    // Space Optimzation
    public int minPathSum(int[][] grid) {
    	int dp[] = new int[grid[0].length];

    	for(int i=0; i<grid.length; i++)
    	{
    		int curr[] = new int[grid[0].length];

    		for(int j=0; j<grid[0].length; j++)
    		{
    			if(i==0 && j==0)
    				curr[j]=grid[i][j];
    			else 
    			{
	    			int left=Integer.MAX_VALUE, up=Integer.MAX_VALUE;

	    			if(i>0)
	    				up=grid[i][j]+dp[j];
	    			if(j>0)
	    				left=grid[i][j]+curr[j-1];

	    			curr[j]=Math.min(left, up);
    			}
    		}
    		dp = Arrays.copyOf(curr, curr.length);
    	}
    	return dp[grid[0].length-1];
    }

}