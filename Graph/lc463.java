import java.util.*;
class lc463
{	
	int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};
	public int dfs(int i, int j, int[][] grid, boolean[][] vis) {
		vis[i][j] = true;

        // Initialize the perimeter variable for current recursion call
		int perimeter = 0;

		for(int[] d: directions)
		{
			int x = i+d[0];
			int y = j+d[1];

            // If it is a border or neighbour is water, increase perimeter
			if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==0)
			     perimeter++;
            // If it is land , perform DFS and add the value to current perimeter
            else if(!vis[x][y] && grid[x][y]==1)
                perimeter += dfs(x, y, grid, vis);
		}

        // Return perimeter from each recursion call
        return perimeter;
	}
	public int islandPerimeter(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int perimeter = 0;

        for(int i=0; i<grid.length; i++)
        {
        	for(int j=0; j<grid[0].length; j++)
        	{
                // Computing the total perimeter in the grid
        		if(grid[i][j]==1 && !vis[i][j])
        			perimeter+=dfs(i, j, grid, vis);
        	}
        }

        return perimeter;
    }
}