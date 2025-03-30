import java.util.*;
class lc827  // Making a Large Island
{
	int[][] directions = {{-1, 0}, {0, -1}, {1,0}, {0,1}};

	// DFS solution
	public int dfs(int i, int j, int ind, int[][] grid, boolean[][] vis) {
		vis[i][j] = true;
		grid[i][j] = ind;
		int count = 1;

		for(int[] d: directions)
		{
			int x = i+d[0];
			int y = j+d[1];

			if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1 && !vis[x][y])
				count+=dfs(x, y, ind, grid, vis);
		}

		return count;
	}
	public int largestIsland(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        // HashMap for stroing individual island numbers and their area
        HashMap<Integer, Integer> map = new HashMap<>();
        int ind = 2;
        boolean zeros = false;

        int ans = 0;
        // perform normal dfs
        for(int i=0; i<grid.length; i++)
        {
        	for(int j=0; j<grid[0].length; j++)
        	{
        		if(grid[i][j]==1 && !vis[i][j])
        		{
        			int area = dfs(i, j, ind, grid, vis);
        			map.put(ind, area);
        			ans = Math.max(ans, area);
        			ind++;
        		}
        		else if(grid[i][j]==0)
        			zeros = true;
        	}
        }

        // if no zeros present, return the max area found so far
        if(!zeros)
        	return ans;

        for(int i=0; i<grid.length; i++)
        {
        	for(int j=0; j<grid[0].length; j++)
        	{
        		// if 0 is found
        		if(grid[i][j]==0)
        		{
        			HashSet<Integer> newIsland = new HashSet<>();
        			int newSize = 1;

        			// find the neighbouring land cells in all 4 directions
        			for(int[] d: directions)
        			{
        				int x = i+d[0];
        				int y = j+d[1];

        				if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]>1)
        					// add the neighbouring island index to the hashSet
        					newIsland.add(grid[x][y]);
        			}

        			// add all the connecting islands area from the hashMap
        			for(int isd: newIsland)
        				newSize+=map.get(isd);

        			// update the max area 
        			ans = Math.max(ans, newSize);
        		}
        	}
        }

        return ans;
    }
}