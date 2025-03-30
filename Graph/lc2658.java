import java.util.*;
class lc2658
{
	int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};
	// DFS Solution
	public int dfs(int i, int j, int[][] grid, boolean[][] vis) {
		vis[i][j] = true;

		// Add the current cell's fish to the answer
		int fish = grid[i][j];

		for(int[] d: directions)
		{
			int x = i+d[0];
			int y = j+d[1];

			// Recursively calculate the total fish collected
			if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]>0 && !vis[x][y])
				fish+=dfs(x, y, grid, vis);
		}
		return fish;
	}
	public int findMaxFish(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int ans = 0;

        for(int i=0; i<grid.length; i++)
        {
        	for(int j=0; j<grid[0].length; j++)
        	{
        		if(grid[i][j]>0 && !vis[i][j])
        		{
        			int res = dfs(i, j, grid, vis);
        			ans = Math.max(ans, res);
        		}
        	}
        }

        return ans;
    }
}