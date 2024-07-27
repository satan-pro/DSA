import java.util.*;
class lc63
{
	// Memoization
	int findPath(int i, int j, int[][] grid, int dp[][])
	{
		if(i==0 && j==0)
			return 1;
		if(i<0 || j<0)
			return 0;
		if(grid[i][j]==1)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		int up = dp[i-1][j];
		int left = dp[i][j-1];
		dp[i][j] = up+left;
		return dp[i][j];
	}
	public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] arr : dp)
        	Arrays.fill(arr,-1);
        int res = findPath(obstacleGrid.length-1, obstacleGrid[0].length-1, obstacleGrid, dp);
        return res;
    }

    // Tabulation
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
    	int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
    	for(int i=0; i<obstacleGrid.length; i++)
    	{
    		for(int j=0; j<obstacleGrid[0].length; j++)
    		{
    			if(obstacleGrid[i][j]==1)
    			{
    				dp[i][j]=0;
    				continue;
    			}
    			if(i==0 && j==0)
    			{
    				dp[i][j]=1;
    				continue;
    			}
    			int up=0;
    			int left=0;
    			if(i>0)
    				up=dp[i-1][j];
    			if(j>0)
    				left=dp[i][j-1];
    			dp[i][j] = up+left;
    		}
    	}
    	return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    // Space Optimization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int dp[] = new int[obstacleGrid[0].length];
    	Arrays.fill(dp,0);
    	for(int i=0; i<obstacleGrid.length; i++)
    	{
    		int temp[] = new int[obstacleGrid[0].length];
    		for(int j=0; j<obstacleGrid[0].length; j++)
    		{
    			if(obstacleGrid[i][j]==1)
    			{
    				temp[j]=0;
    				continue;
    			}
    			if(i==0 && j==0)
    			{
    				temp[j]=1;
    				continue;
    			}
    			int up=dp[j];
    			int left=0;
    			if(j>0)
    				left=temp[j-1];
    			temp[j] = up+left;
    		}
    	}
    	return dp[obstacleGrid[0].length-1];
    }
}