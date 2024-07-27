import java.util.*;
class microsoft2
{
	int findPath(int i, int j, String st, int startRow, int startCol, int[][] grid, int dp[][], String dp2[][])
	{
		if(i==startRow && j==startCol)
			return 0;
		if(i<0 || j<0)
			return Math.pow(10,8);
		if(grid[i][j]==1)
			return Math.pow(10,8);
		if(dp[i][j]!=-1)
		{
			dp2[i][j]=st;
			return dp[i][j];
		}

		int down = 1 + findPath(i-1, j, st+"S", startRow, startCol, grid, dp);
		int left = 1 + findPath(i, j-1, st+"W", startRow, startCol, grid, dp);
		int right = 1 + findPath(i, j+1, st+"E", startRow, startCol, grid, dp);
		dp[i][j] = Math.min(down, Math.min(left, right));

		return dp[i][j];
	}

	int findPath()
	{
		int dp[][] = new int[m][n];

		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				int down, left, right;
				down=left=right=Integer.MAX_VALUE;

				if(i>0)
					down=1+dp[i-1][j];
				if(j>0)
					left=1+dp[i][j-1];
				if(j+1<n)
					right=1+dp[i][j+1];

				int min = Math.min(down, Math.min(left, right));
				dp[i][j]=min;

				if(down==min)
					sp[i][j]=sp[i-1][j]+"S";
				else if(left==min)
					sp[i][j]=sp[i][j-1]+"W";
				else if(right==min)
					sp[i][j]=sp[i][j+1]
			}
		}
	}

	public String solution(String forth)
	{
		List<List<Integer>> route = new ArrayList<>();

		int row=0, col=0;
		int maxRow=Integer.MAX_VALUE, maxCol=Integer.MAX_VALUE;
		for(int i=0; i<forth.length(); i++)
		{
			if(forth.charAt(i)=="N")
				row++;
			else if(forth.charAt(i)=="E")
				col++;
			else if(forth.charAt(i)=="w")
				col--;
			List<Integer> ls = new ArrayList<>();
			ls.add(row);
			ls.add(col);
			if(row>maxRow)
				maxRow=row;
			if(col>maxCol)
				maxCol=col;
			route.add(new ArrayList<>(ls));
		}

		int arr[][] = new int[maxRow+2][maxCol+2];
		for(int rows[]: arr)
			Arrays.fill(rows, 0);

		for(int i=1; i<route.size(); i++)
		{
			arr[route.get(i).get(0)+2][route.get(i).get(1)+2]=1;
		}

		int dp[][] = new int[arr.length][arr[0].length];
		for(int a[]:dp)
			Arrays.fill(dp, -1);


	}	
}