import java.util.*;
class lc62
{
	// Memoization
	int findPath(int i, int j, int dp[][])
	{
		if(i==0 && j==0)
			return 1;
		if(i<0 || j<0)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		int up = findPath(i-1, j, dp);
		int left = findPath(i, j-1, dp);
		dp[i][j] = up+left;
		return dp[i][j];
	}
	public int uniquePaths1(int m, int n) {
		int dp[][] = new int[m][n];
		for(int arr[] : dp)
			Arrays.fill(arr,-1);
        int res = findPath(m-1,n-1, dp);
        return res;
    }

    // Tabulation
    public int uniquePaths2(int m, int n)
    {
    	int dp[][] = new int[m][n];
    	for(int i=0; i<m; i++)
    	{
    		for(int j=0; j<n; j++)
    		{
    			int up=0;
    			int left=0;
    			if(i==0 && j==0)
				{
					dp[i][j]=1;
					continue;
				}
    			if(i>0)
    				up = dp[i-1][j];
    			if(j>0)
    				left = dp[i][j-1];

    			dp[i][j] = up+left;
    		}
    	}
    	return dp[m-1][n-1];
    }

    // Space Optimization
    public int uniquePaths(int m, int n)
    {
    	int dp[] = new int[n];
    	Arrays.fill(dp,0);
    	for(int i=0; i<m; i++)
    	{
    		int temp[] = new int[n];
    		for(int j=0; j<n; j++)
    		{
    			int up=dp[j];
    			int left=0;
    			if(i==0 && j==0)
				{
					temp[j]=1;
					continue;
				}
				if(j>0)
					left=temp[j-1];
    			temp[j] = up+left;
    		}
    		dp = Arrays.copyOf(temp, temp.length);
    	}
    	return dp[n-1];
    }

    public static void main(String[] args) {
    	lc62 obj = new lc62();
    	int res = obj.uniquePaths(3,7);
    	System.out.println(res);
    }
}