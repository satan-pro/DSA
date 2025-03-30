import java.util.*;
class lc1905
{	
	int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

	public boolean dfs(int i, int j, int[][] grid1, int[][] grid2, boolean[][] vis) {
		if(i<0 || j<0 || i>=grid1.length || j>=grid2[0].length)
			return true;
		if(grid2[i][j]==0 || vis[i][j])
			return true;
		else if(grid2[i][j]==1 && grid1[i][j]==0)
			return false;

		vis[i][j] = true;

		boolean isValid = true;
		for(int[] d: directions)
		{
			int x = i+d[0];
			int y = j+d[1];

			isValid = dfs(x, y, grid1, grid2, vis) && isValid;
		}
		return isValid;
	}
	public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean vis[][] = new boolean[grid2.length][grid2[0].length];

        int count=0;
        for(int i=0; i<grid2.length; i++)
        {
        	for(int j=0; j<grid2[0].length; j++)
        	{
        		boolean valid = false;
        		if(grid2[i][j]==1 && !vis[i][j])
        		{
        			if(dfs(i, j, grid1, grid2, vis))
        			{
        				count++;
        			}
        		}
        	}
        }

        return count;
    }
}