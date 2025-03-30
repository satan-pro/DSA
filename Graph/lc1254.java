import java.util.*;
class lc1254
{
	int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

	boolean dfs(int i, int j, int[][] grid, boolean[][] vis) {
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
			return false;
		if(grid[i][j]==1 || vis[i][j])
			return true;

		vis[i][j] = true;

		boolean top = dfs(i - 1, j, grid, vis);
	    boolean left = dfs(i, j - 1, grid, vis);
	    boolean bottom = dfs(i + 1, j, grid, vis);
	    boolean right = dfs(i, j + 1, grid, vis);

		return top && left && bottom && right;
	}
	public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        int count = 0;

        for(int i=1; i<m-1; i++)
        {
        	for(int j=1; j<n-1; j++)
        	{
        		boolean valid = false;
        		if(grid[i][j]==0 && !vis[i][j])
        		{
        			valid = dfs(i,j,grid,vis);
        		}
        		if(valid)
        			count++;
        	}
        }

        return count;
    }
}