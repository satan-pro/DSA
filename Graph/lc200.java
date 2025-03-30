import java.util.*;
class lc200  // Number of Islands
{
	int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

	// DFS solution
	public void dfs(int i, int j, char[][] grid, boolean[][] vis) {
		vis[i][j] = true;

		for(int[] d: directions)
		{
			int x = i+d[0];
			int y = j+d[1];

			if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && !vis[x][y] && grid[x][y]=='1')
				dfs(x,y,grid,vis);
		}
	}
	public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int count=0;
        for(int i=0; i<grid.length; i++)
        {
        	for(int j=0; j<grid[0].length; j++)
        	{
        		if(grid[i][j]=='1' && !vis[i][j])
        		{
        			count++;
        			dfs(i,j,grid,vis);
        		}
        	}
        }

        return count;
    }

    // BFS Solution
    public int numIslands1(char[][] grid) {
    	Queue<int[]> q = new LinkedList<>();
    	boolean[][] vis = new boolean[grid.length][grid[0].length];

    	int count = 0;

    	for(int i=0; i<grid.length; i++)
    	{
    		for(int j=0; j<grid[0].length; j++)
    		{
    			if(grid[i][j]=='1' && !vis[i][j])
    			{
    				count++;
    				q.offer(new int[]{i,j});
    				vis[i][j] = true;

    				while(!q.isEmpty())
    				{
    					int[] curr = q.poll();

    					for(int[] d: directions)
    					{
    						int x = curr[0]+d[0];
    						int y = curr[1]+d[1];

    						if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='1' && !vis[x][y])
    						{
    							vis[x][y] = true;
    							q.offer(new int[]{x,y});
    						}
    					}
    				}
    			}
    		}
    	}

    	return count;
    }
}