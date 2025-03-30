import java.util.*;
class lc417
{	
	int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	public void dfs(int i, int j, int[][] heights, boolean[][] ocean) {
		if(ocean[i][j])
			return;
		ocean[i][j] = true;

		for(int[] d: directions)
		{
			int x = i+d[0];
			int y = j+d[1];

			if(x>=0 && y>=0 && x<heights.length && y<heights[0].length && heights[x][y]>=heights[i][j])
				dfs(x, y, heights, ocean);
		}
	}
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int n = heights.length, m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
        	dfs(i, 0, heights, pacific);
        	dfs(i, m-1, heights, atlantic);
        }
        for(int i=0; i<m; i++)
        {
        	dfs(0, i, heights, pacific);
        	dfs(n-1, i, heights, atlantic);
        }

        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<m; j++)
        	{
        		if(pacific[i][j] && atlantic[i][j])
        			ans.add(Arrays.asList(i, j));
        	}
        }

        return ans;
    }
}