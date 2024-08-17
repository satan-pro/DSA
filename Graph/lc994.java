import java.util.*;
class lc994  // Rotting Oranges
{
	class Pair
	{
		int x;
		int y;
		public Pair(int a, int b)
		{
			x=a;
			y=b;
		}
	}
	int checkValid(int[][] grid, int x, int y, Queue<Pair> q)
	{
		if(x<0 || y<0 || x>=grid.length || y>=grid[0].length)
			return 0;
		if(grid[x][y]==1)
		{
			q.offer(new Pair(x, y));
			grid[x][y]=2;
			return 1;
		}
		return 0;
	}
	public int orangesRotting(int[][] grid) {
        int count=0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++)
        {
        	for(int j=0; j<grid[i].length; j++)
        	{
        		if(grid[i][j]==1)
        			count++;
        		if(grid[i][j]==2)
        			q.offer(new Pair(i, j));
        	}
        }

        int minutes=0;
        while(!q.isEmpty())
        {
        	int size = q.size();
        	boolean rotten = false;

        	for(int k=0; k<size; k++)
        	{
	        	Pair curr = q.poll();
	        	int i = curr.x;
	        	int j = curr.y;

	        	int change = checkValid(grid, i+1, j, q)+checkValid(grid, i-1, j, q)+checkValid(grid, i, j+1, q)+checkValid(grid, i, j-1, q);

	        	if(change>0)
	        	{
	        		rotten = true;
	        		count-=change;
	        	}
			}
			if(rotten)
				minutes++;
        }
        if(count>0)
        	return -1;
        return minutes;

    }
}