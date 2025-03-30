import java.util.*;
class lc1034  // Coloring a Border
{
	int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};

	// DFS solution
	public void dfs(int i, int j, int color, int[][] grid, boolean[][] vis, List<int[]> borders) {
		vis[i][j] = true;
		int prevColor = grid[i][j];

		// variable to check if it is a border cell
		boolean isBorder = false;

		for(int[] d: directions)
		{
			int x = i+d[0];
			int y = j+d[1];

			// If the neighbouring cell is of different color, make isBorder = true
			if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]!=prevColor)
				isBorder = true;
			if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==prevColor && !vis[x][y])
				dfs(x, y, color, grid, vis, borders);
		}

		// Is the cell is at the last row or last col or if neighbouring cells are diff (isBorder), then add the current cell to the list
		if(i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1 || isBorder)
			borders.add(new int[]{i,j});
	}
	public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        // Create an arraylist to store the border cells
        List<int[]> borders = new ArrayList<>();

        // DFS is needed only on the given cell value
        dfs(row, col, color, grid, vis, borders);

        // Color al the border cells
        for(int[] cell: borders)
        	grid[cell[0]][cell[1]] = color;

        return grid;
    }
}