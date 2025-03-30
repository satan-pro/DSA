import java.util.*;
class lc1267
{
	int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	public int dfs(int i, int j, int[][] grid, boolean[][] vis) {
		vis[i][j] = true;

		int count = 0;
		for(int[] d: directions)
		{
			int x = i+d[0];
			int y = j+d[1];

			if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1 && !vis[x][y])
				count+= dfs(x, y, grid, vis);
		}

		if(count>0)
			count++;
		return count;
	}
	public int countServers(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int ans =0;
        for(int i=0; i<grid.length; i++)
        {
        	for(int j=0; j<grid[0].length; j++)
        	{
        		if(grid[i][j]==0 && !vis[i][j])	
        			ans+= dfs(i, j, grid, vis);
        	}
        }

        return ans;
    }
}