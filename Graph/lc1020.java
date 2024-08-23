import java.util.*;
class lc1020
{
	void dfs(int i, int j, int[][] grid, boolean[][] vis)
	{
		vis[i][j]=true;
		int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

		for(int direction[] : directions)
		{
			int x = i+direction[0];
			int y = j+direction[1];

			if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1 && !vis[x][y])
				dfs(x, y, grid, vis);
		}
	}
	public int numEnclaves(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid[0].length; i++)
        {
        	if(grid[0][i]==1 && !vis[0][i])
        		dfs(0, i, grid, vis);

        	if(grid[grid.length-1][i]==1 && !vis[grid.length-1][i])
        		dfs(grid.length-1, i, grid, vis);
        }
        for(int i=0; i<grid.length; i++)
        {
        	if(grid[i][0]==1 && !vis[i][0])
        		dfs(i, 0, grid, vis);

        	if(grid[i][grid[0].length-1]==1 && !vis[i][grid[0].length-1])
        		dfs(i, grid[0].length-1, grid, vis);
        }

        int count=0;
        for(int i=1; i<grid.length; i++)
        {
        	for(int j=1; j<grid[i].length; j++)
        	{
        		if(grid[i][j]==1 && !vis[i][j])
        			count++;
        	}
        }

        return count;
    }
}