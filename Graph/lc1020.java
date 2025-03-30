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

    // BFS Traversal
    public int numEnclaves1(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        // Traverse Boundary Elements
        for(int i=0; i<m; i++)
        {
        	// First Column
        	if(grid[i][0]==1 && !vis[i][0])
        	{
        		vis[i][0] = true;
        		q.offer(new int[]{i,0});
        	}

        	// Last Column
        	if(grid[i][n-1]==1 && !vis[i][n-1])
        	{
        		vis[i][n-1] = true;
        		q.offer(new int[]{i,n-1});
        	}
        }

        for(int i=0; i<n; i++)
        {
        	// First Row
        	if(grid[0][i]==1 && !vis[0][i])
        	{
        		vis[0][i] = true;
        		q.offer(new int[]{0,i});
        	}

        	// Last Row
        	if(grid[m-1][i]==1 && !vis[m-1][i])
        	{
        		vis[m-1][i] = true;
        		q.offer(new int[]{m-1,i});
        	}
        }

        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

        // Perform BFS traversal on the boundary elements
        while(!q.isEmpty())
        {
        	int curr[] = q.poll();
        	int i = curr[0];
        	int j = curr[1];

        	for(int[] d: directions)
        	{
        		int x = i+d[0];
        		int y = j+d[1];

        		// Add new elements to the queue which are linked to the boundary elements
        		if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1 && !vis[x][y])
        		{
        			vis[x][y] = true;
        			q.offer(new int[]{x,y});
        		}
        	}
        }

        int count = 0;
        // Count the no of invalid cells 
        for(int i=0; i<m; i++)
        {
        	for(int j=0; j<n; j++)
        	{
        		if(grid[i][j]==1 && !vis[i][j])
        			count++;
        	}
        }

        // Return count of invalid cells
        return count;
    }
}