import java.util.*;
class lc695  // Max Area of Island
{
	public int maxAreaOfIsland(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int maxArea = 0;

        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

        for(int i=0; i<grid.length; i++)
        {
        	for(int j=0; j<grid[0].length; j++)
        	{
        		if(grid[i][j]==1 && !vis[i][j])
        		{
        			vis[i][j] = true;
        			q.offer(new int[]{i,j});

        			int currArea = 0;
        			while(!q.isEmpty())
        			{
        				int[] curr = q.poll();
        				currArea++;

        				for(int[] d: directions)
        				{
        					int x = curr[0]+d[0];
        					int y = curr[1]+d[1];

        					if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1 && !vis[x][y])
        					{
        						vis[x][y] = true;
        						q.offer(new int[]{x,y});
        					}
        				}
        			}

        			maxArea = Math.max(maxArea, currArea);
        		}
        	}
        }

        return maxArea;
    }
}