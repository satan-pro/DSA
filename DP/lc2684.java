import java.util.*;
class lc2684
{
	// Memoization Approach
	public boolean isValid(int i, int j, int[][] grid) {
		if(i>=grid.length || j>=grid[0].length || i<0 || j<0)
			return false;
		return true;
	}
	public int findMoves(int i, int j, int[][] grid, int[][] dp) {
		if(!isValid(i, j, grid))
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];

		int tr=0,r=0,br=0;

		if(isValid(i-1, j+1, grid) && grid[i-1][j+1]>grid[i][j])
			tr = findMoves(i-1, j+1, grid, dp);
		if(isValid(i, j+1, grid) && grid[i][j+1]>grid[i][j])
			r = findMoves(i, j+1, grid, dp);
		if(isValid(i+1, j+1, grid) && grid[i+1][j+1]>grid[i][j])
			br = findMoves(i+1, j+1, grid, dp);

		dp[i][j] = 1+Math.max(tr, Math.max(r, br));
		return dp[i][j];
	}
	public int maxMoves1(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
        int dp[][] = new int[m][n];

        for(int[] arr: dp)
        	Arrays.fill(arr, -1);

        int maxi = 0;
        for(int i=0; i<m; i++)
        {
        	maxi = Math.max(maxi, findMoves(i, 0, grid, dp));
        }

        return maxi-1;
    }

    // Tabulation Approach
    public int maxMoves(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
        int dp[][] = new int[m][n];

        for(int i=0; i<m; i++)
        	dp[i][n-1] = 1;

        int maxi = 0;

        for(int j=n-2; j>=0; j--)
        {
        	for(int i=0; i<m; i++)
        	{
        		int tr=0, r=0, br=0;

        		if(isValid(i-1, j+1, grid) && grid[i][j]<grid[i-1][j+1])
        			tr = dp[i-1][j+1];
        		if(isValid(i, j+1, grid) && grid[i][j]<grid[i][j+1])
        			r = dp[i][j+1];
        		if(isValid(i+1, j+1, grid) && grid[i][j]<grid[i+1][j+1])
        			br = dp[i+1][j+1];

        		dp[i][j] = 1+Math.max(tr, Math.max(r, br));	
        	}
        }

        for(int i=0; i<m; i++)
        	maxi = Math.max(maxi, dp[i][0]);

        return maxi-1;
    }
}