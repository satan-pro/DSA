import java.util.*;
class netcore1
{
	public static int solve(int n, int[][] tiles) {
        int[][] dp = new int[n][n];
        
        // Initialize the DP array with a high value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // Initialize the starting point with the leading zeros in the first tile
        dp[0][0] = countLeadingZeros(tiles[0][0]);
        
        // Fill the DP array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check right move (i, j+1)
                if (j + 1 < n) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + countLeadingZeros(tiles[i][j + 1]));
                }
                
                // Check down move (i+1, j)
                if (i + 1 < n) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + countLeadingZeros(tiles[i + 1][j]));
                }
            }
        }
        
        // The minimum leading zeros to reach the bottom-right corner
        return dp[n - 1][n - 1];
    }
    
    // Helper function to count leading zeros in a tile's value
    private static int countLeadingZeros(int num) {
        int count = 0;
        while (num %10== 0 && num!=0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] tiles = {
            {2, 3, 10},
            {5, 10, 3},
            {4, 2, 5}
        };
        
        int result = solve(n, tiles);
        System.out.println("Minimum leading zeros to reach the treasure: " + result);
    }
}