import java.util.*;
class lc542  // 0/1 Matrix
{
	// Using a Pair class

    // Intuition : Create a Queue for BFS Traversal
    // Add nodes to queue only when the value is 0
    // Perform BFS traversal on the matrix nodes
    // Add only those nodes which are dimensionally valid and not visited
    // Increase the count of each cell for the corresponding distance
    
	class Pair
	{
		int arr[];
		int val;
		public Pair(int[] a, int n)
		{
			this.arr=a;
			this.val=n;
		}
	}
	public int[][] updateMatrix1(int[][] mat) {
        int res[][] = new int[mat.length][mat[0].length];
        boolean vis[][] = new boolean[mat.length][mat[0].length];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<mat.length; i++)
        {
        	for(int j=0; j<mat[i].length; j++)
        	{
        		if(mat[i][j]==0)
        		{
        			vis[i][j]=true;
        			q.offer(new Pair(new int[]{i, j}, 0));
        		}
        	}
        }

        int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty())
        {
        	Pair curr = q.poll();
        	int x = curr.arr[0];
        	int y = curr.arr[1];
        	int val = curr.val;

        	for(int[] direction : directions)
        	{
        		int i = x+direction[0];
        		int j = y+direction[1];

        		if(i>=0 && j>=0 && i<mat.length && j<mat[0].length && !vis[i][j])
        		{
        			res[i][j] = val+1;
        			vis[i][j] = true;
        			q.offer(new Pair(new int[]{i, j}, res[i][j]));
        		}
        	}
        }
        return res;
    }

    // Without using a Pair class and storing value as an array in a Queue
    public int[][] updateMatrix(int[][] mat) {
        int res[][] = new int[mat.length][mat[0].length];
        boolean vis[][] = new boolean[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<mat.length; i++)
        {
        	for(int j=0; j<mat[i].length; j++)
        	{
        		if(mat[i][j]==0)
        		{
        			vis[i][j]=true;
        			q.offer(new int[]{i, j});
        		}
        	}
        }

        int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty())
        {
        	int curr[] = q.poll();
        	int x = curr[0];
        	int y = curr[1];

        	for(int[] direction : directions)
        	{
        		int i = x+direction[0];
        		int j = y+direction[1];

        		if(i>=0 && j>=0 && i<mat.length && j<mat[0].length && !vis[i][j])
        		{
        			res[i][j] = res[x][y]+1;
        			vis[i][j] = true;
        			q.offer(new int[]{i, j});
        		}
        	}
        }
        return res;
    }
}