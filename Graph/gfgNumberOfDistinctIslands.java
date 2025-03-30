import java.util.*;
class gfgNumberOfDistinctIslands
{
	int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	public String dfs(int i, int j, int[][] grid, boolean[][] vis) {
		vis[i][j] = true;

		String moves = "TRDL";
		StringBuilder ans = new StringBuilder("I");

		for(int k=0; k<directions.length; k++)
		{
			int x = i+directions[k][0];
			int y = j+directions[k][1];

			if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1 && !vis[x][y])
			{
				ans.append(moves.charAt(k));
				ans.append(dfs(x, y, grid, vis));
			}
		}
		ans.append("B");
		return ans.toString();
	}
	int countDistinctIslands(int[][] grid) {
        // Your Code here
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Set<String> set = new HashSet<>();

        int count = 0;

        for(int i=0; i<grid.length; i++)
        {
        	for(int j=0; j<grid[0].length; j++)
        	{
        		if(grid[i][j]==1 && !vis[i][j])
        		{
        			String res = dfs(i, j, grid, vis);

        			if(!set.contains(res))
        			{
        				count++;
        				set.add(res);
        			}
        		}
        	}
        }
        return count;
    }
}