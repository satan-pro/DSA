import java.util.*;
class lc2017  // Grid Game
{
	public long gridGame(int[][] grid) {
       int n = grid[0].length;
       long row1 = 0;

       // prefix sum of all the elements in the first row 
       for(int i=0; i<n; i++)
            row1+= grid[0][i];

        long row2 = 0, ans = Long.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
        	// traversing the first row and decreasing the value
            row1-= grid[0][i];
            // finding the minimum of maximum points of the two rows at current position
            ans = Math.min(ans, Math.max(row1, row2));
            // traversing the second row and adding the value
            row2+= grid[1][i];
        }

        return ans;
    }
}