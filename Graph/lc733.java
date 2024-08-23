import java.util.*;
class lc733  // Flood Fill
{
	// Intuition : Perform a DFS from the starting cell and traverse 4-dimentionally
	// Change the values of those cells which have the same number as the starting cell

	// Function to check if cell is valid or not
	boolean isValid(int x, int y, int[][] arr, int pixel)
	{
		if(x<0 || y<0 || x>=arr.length || y>=arr[x].length)
			return false;
		if(arr[x][y]==pixel)
			return true;
		return false;
	}
	// DFS Traversal
	void dfs(int[][] image, int x, int y, int color, int pixel)
	{
		image[x][y]=color;

		if(isValid(x+1, y, image, pixel))
			dfs(image, x+1, y, color, pixel);
		if(isValid(x-1, y, image, pixel))
			dfs(image, x-1, y, color, pixel);
		if(isValid(x, y+1, image, pixel))
			dfs(image, x, y+1, color, pixel);
		if(isValid(x, y-1, image, pixel))
			dfs(image, x, y-1, color, pixel);
	}
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		// Check if cell value is same as color; if same then no need for DFS traversal
		if(image[sr][sc]==color)
			return image;
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
}