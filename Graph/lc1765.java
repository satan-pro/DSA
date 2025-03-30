import java.util.*;
class lc1765  // Map of Highest Peak
{
	// BFS solution
	public int[][] highestPeak(int[][] isWater) {
		int n = isWater.length;
		int m = isWater[0].length;
		boolean[][] vis = new boolean[n][m];
		int[][] ans = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<m; j++)
        	{	
        		// Add all the water cells to the queue
        		if(isWater[i][j]==1)
        		{
        			vis[i][j] = true;
        			q.offer(new int[]{i, j, 0});
        		}
        	}
        }

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while(!q.isEmpty())
        {
        	int[] curr = q.poll();
        	int i = curr[0];
        	int j = curr[1];
        	int val = curr[2];

        	ans[i][j] = val;

        	// Travel to neighbouring cells 
        	for(int[] d: directions) {
        		int x = i+d[0];
        		int y = j+d[1];

        		if(x>=0 && y>=0 && x<n && y<m && !vis[x][y])
        		{
        			vis[x][y] = true;
        			// maximize height by increasing the height of neighbouring cell
        			q.offer(new int[]{x, y, val+1});
        		}
        	}
        }

        return ans;
    }
}