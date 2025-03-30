import java.util.*;
class lc1992
{	
	// BFS Solution
	public int[][] findFarmland(int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[land.length][land[0].length];

        // Create an arraylist to store the ans and later transfer the contents to a 2D array
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int k = -1;
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

        for(int i=0; i<land.length; i++)
        {
        	for(int j=0; j<land[0].length; j++)
        	{
        		// If the cell is a land and not visited, perform DFS
        		if(land[i][j]==1 && !vis[i][j])
        		{
        			vis[i][j] = true;
        			k++;
        			// Add the current cell to the list (as it is the starting topmost left cell)
        			list.add(new ArrayList<>());
        			list.get(k).add(i);
        			list.get(k).add(j);

        			// Add the current cell to the queue
        			q.offer(new int[]{i,j});
        			// Create a prev array to store the last visited land cell
        			int prev[] = new int[2];
        			// Add the current cell's positions to prev, as it has been recently visited 
        			// This helps if the land is a single cell
        			prev[0] = i;
        			prev[1] = j;

        			while(!q.isEmpty())
        			{
        				int[] curr = q.poll();

        				// Traverse in all 4 directions to find land
        				for(int[] d: directions)
        				{
        					int x = curr[0]+d[0];
        					int y = curr[1]+d[1];

        					if(x>=0 && y>=0 && x<land.length && y<land[0].length && land[x][y]==1 && !vis[x][y])
        					{	
        						// Update the prev arr with the currently visited land cell
        						prev[0] = x;
        						prev[1] = y;
        						vis[x][y] = true;
        						q.offer(new int[]{x,y});
        					}
        				}
        			}

        			// Add the recently visited land cell to the ArrayList (as this is the bottom-most right cell)
        			list.get(k).add(prev[0]);
        			list.get(k).add(prev[1]);
        		}
        	}
        }

        // This 2D array stores the answer to be returned
        int[][] ans = new int[list.size()][4];

        // Transferring the contents of the ArrayList to the 2D array
        for(int i=0; i<list.size(); i++)
        {
        	for(int j=0; j<4; j++)
        	{
        		ans[i][j] = list.get(i).get(j);
        	}
        }

        return ans;
    }
}