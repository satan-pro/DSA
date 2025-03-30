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

    // Solving using BFS
    public void solve1(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[board.length][board[0].length];

        // Boundary element traversals
        for(int i=0; i<m; i++)
        {
        	// First Column
        	if(board[i][0]=='O' && !vis[i][0])
        	{
        		vis[i][0] = true;
        		q.offer(new int[]{i,0});
        	}

        	// Last Column
        	if(board[i][n-1]=='O' && !vis[i][n-1])
        	{
        		vis[i][n-1] = true;
        		q.offer(new int[]{i,n-1});
        	}
        }

        for(int i=0; i<n; i++)
        {
        	// First Row
        	if(board[0][i]=='O' && !vis[0][i])
        	{
        		vis[0][i] = true;
        		q.offer(new int[]{0,i});
        	}

        	// Last Row
        	if(board[m-1][i]=='O' && !vis[m-1][i])
        	{
        		vis[m-1][i] = true;
        		q.offer(new int[]{m-1,i});
        	}
        }

        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};

        // BFS on the boundary elements are their connected cells with value 'O'
        while(!q.isEmpty())
        {
        	int[] curr = q.poll();
        	int i = curr[0];
        	int j = curr[1];

        	for(int[] d: directions)
        	{
        		int x = i+d[0];
        		int y = j+d[1];

        		if(x>=0 && y>=0 && x<m && y<n && board[x][y]=='O' && !vis[x][y])
        		{
        			vis[x][y]=true;
        			q.offer(new int[]{x,y});
        		}
        	}
        }

        // Building the result array
        // Mark only those cells with 'O' which have not been visited by the BFS traversal, as they are the only valid cells
        for(int i=0; i<m; i++)
        {
        	for(int j=0; j<n; j++)
        	{
        		if(board[i][j]=='O' && !vis[i][j])
        			board[i][j]='X';
        	}
        }
    }
}