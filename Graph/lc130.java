import java.util.*;
class lc130  // Surrounded Regions
{
	// Intuition : Do DFS traversal for all boundary cells if the cell contains 'O' 
	// Mark all the visited cells as true
	// Now check the internal cells of the grid (non boundary cells)
	// If any internal cell contains 'O' convert it to 'X'
	void dfs(int x, int y, char[][] board, boolean[][] vis, int[][] directions)
	{
		vis[x][y]=true;

		for(int direction[] : directions)
		{
			int x1 = x+direction[0];
			int y1 = y+direction[1];

			if(x1>=0 && y1>=0 && x1<board.length && y1<board[0].length && !vis[x1][y1] && board[x1][y1]=='O')
				dfs(x1, y1, board, vis, directions);
		}
	}
	public void solve(char[][] board) {
        int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean vis[][] = new boolean[board.length][board[0].length];
        
        if(board.length<=2 || board[0].length<=2)
        	return;

        // Boundary Traversals
       for(int i=0; i<board.length; i++)
       {
       		// First column
       		if(board[i][0]=='O' && !vis[i][0])
       			dfs(i, 0, board, vis, directions);

       		// Last Column
       		if(board[i][board[0].length-1]=='O' && !vis[i][board[0].length-1])
       			dfs(i, board[0].length-1, board, vis, directions);
       }
       for(int i=0; i<board[0].length; i++)
       {
       		// First row
       		if(board[0][i]=='O' && !vis[0][i])
       			dfs(0, i, board, vis, directions);

       		// Last row
       		if(board[board.length-1][i]=='O' && !vis[board.length-1][i])
       			dfs(board.length-1, i, board, vis, directions);
       }
        for(int i=1; i<board.length-1; i++)
        {
        	for(int j=1; j<board[0].length-1; j++)
        	{
        		// Changing internal cells
        		if(board[i][j]=='O' && !vis[i][j])
        			board[i][j]='X';
        	}
        }
    }
}