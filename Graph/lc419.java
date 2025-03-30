import java.util.*;
class lc419  // BattleShips in a Board
{
	// DFS Solution
	public void dfs(int i, int j, int type, char[][] board, boolean[][] vis) {
		vis[i][j] = true;

		int x = i, y=j;

		// Since we can move only either vertically or horizontally, we use the type variable
		// Type 1 : Vertical movement
		if(type==1)
		{
			// Trying moving vertically in both +ve and -ve directions
			for(int k=1; k<=2; k++)
			{
				if(k%2==1)
					x = i-1;
				else 
					x = i+1;

				if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]=='X' && !vis[x][y])
					dfs(x, y, type, board, vis);
			}
		}
		// Type 2: Horizontal movement
		else if(type==2)
		{
			// Try moving horizontally in both +ve and -Ve directions
			for(int k=1; k<=2; k++)
			{
				if(k%2==1)
					y = j-1;
				else 
					y = j+1;

				if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]=='X' && !vis[x][y])
					dfs(x, y, type, board, vis);
			}
		}
	}
	public int countBattleships(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];

        int count = 0;
        // Traverse every cell in the board
        for(int i=0; i<board.length; i++)
        {
        	for(int j=0; j<board[0].length; j++)
        	{
        		if(board[i][j]=='X' && !vis[i][j])
        		{
        			// Apply both vertical and horizontal DFS traversals to the cell
        			dfs(i, j, 1, board, vis);
        			dfs(i, j, 2, board, vis);
        			// Increase the count of the battleship 
        			count++;
        		}
        	}
        }

        return count;
    }
}