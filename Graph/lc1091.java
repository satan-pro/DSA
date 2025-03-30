import java.util.*;
class lc1091  // Shortest Path in Binary Matrix
{
	public int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		boolean vis[][] = new boolean[n][m];

		if(grid[0][0]==1 || grid[n-1][m-1]==1)
        	return -1;

        // priority queue to count the distance of the path
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        pq.offer(new int[]{1, 0, 0});
        
        int ans = -1;
        int directions[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

        // perform a bfs using a priority queue
        while(!pq.isEmpty())
        {
        	int[] curr = pq.poll();

        	// if you reach the last cell, return the distance
        	if(curr[1]==n-1 && curr[2]==m-1)
        	{
        		return curr[0];
        	}

        	// traverse in all 8-directions
        	for(int[] d: directions)
        	{
        		int x = curr[1]+d[0];
        		int y = curr[2]+d[1];

        		if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0 && !vis[x][y])
        		{	
        			// make the cell visited to same time and space complexity
        			vis[x][y] = true;
        			pq.offer(new int[]{curr[0]+1, x, y});
        		}
        	}
        }

        return ans;
    }
}