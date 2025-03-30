import java.util.*;
class lc1631  // Path with Minimum Effort
{
	public int minimumEffortPath(int[][] heights) {
		int n = heights.length;
		int m = heights[0].length;
		int dist[][] = new int[n][m];

		for(int[] a: dist)
			Arrays.fill(a, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0, 0, 0});

        int directions[][]  = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int ans = -1;

        while(!pq.isEmpty()) 
        {
        	int[] curr = pq.poll();

        	if(curr[1]==n-1 && curr[2]==m-1)
        		return curr[0];

        	for(int[] d: directions) 
        	{
        		int x = curr[1]+d[0];
        		int y = curr[2]+d[1];

        		if(x>=0 && y>=0 && x<n && y<m)
        		{
        			int peakDiff = Math.max(Math.abs(heights[x][y]-heights[curr[1]][curr[2]]), curr[0]);
        			
        			if(peakDiff < dist[x][y])
        			{
        				dist[x][y] = peakDiff;
        				pq.offer(new int[]{peakDiff, x, y});
        			}
        		}
        	}
        }

        return ans;
    }
}