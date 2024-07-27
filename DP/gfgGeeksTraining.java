import java.util.*;
class gfgGeeksTraining
{
	// Memoization Approach
	int maxProf(int ind, int last, int points[][], int N, int dp[][])
	{
		if(ind==0)
		{
			int max=0;
			for(int i=0; i<3; i++)
			{
				if(i!=last)
				{
					max = Math.max(max, points[ind][i]);
				}
			}
			return max;
		}

		if(dp[ind][last]!=-1)
			return dp[ind][last];

		int profit=0;
		for(int i=0; i<3; i++)
		{
			if(i!=last){
			int total=points[ind][i]+maxProf(ind-1, i, points, N, dp);
			profit = Math.max(profit, total);
			}
		}
		dp[ind][last]=profit;
		return profit;
	}
	public int maximumPoints2(int points[][],int N){
        //code here

		int dp[][] = new int[N][4];
		for(int[] row : dp)
			Arrays.fill(row, -1);

		int res = maxProf(N-1, 3, points, N, dp);

		return res;
    }

    // Tabulation Approach
    public int maximumPoints(int points[][], int N)
    {
    	int dp[][] = new int[N][4];

    	dp[0][0] = Math.max(points[0][1],points[0][2]);
    	dp[0][1] = Math.max(points[0][2],points[0][0]);
    	dp[0][2] = Math.max(points[0][0],points[0][1]);
    	dp[0][3] = Math.max(points[0][0],Math.max(points[0][1], points[0][2]));

    	for(int i=1; i<N; i++)
    	{
    		for(int j=0; j<4; j++)
    		{
    			int max=0;
    			for(int k=0; k<3; k++)
    			{
    				if(k!=j)
    				{
    					int point = points[i][k]+dp[i-1][k];
    					dp[i][j] = Math.max(dp[i][j], point);
    				}
    			}
    		}
    	}
    	return dp[N-1][3];
    }

    // Space Optimization
    public int maximumPoints3(int points[][], int N)
    {
    	int dp[] = new int[4];

    	dp[0] = Math.max(points[0][1],points[0][2]);
    	dp[1] = Math.max(points[0][2],points[0][0]);
    	dp[2] = Math.max(points[0][0],points[0][1]);
    	dp[3] = Math.max(points[0][0],Math.max(points[0][1], points[0][2]));

    	for(int i=1; i<N; i++)
    	{
    		int temp[] = new int[4];
    		for(int j=0; j<4; j++)
    		{
    			for(int k=0; k<3; k++)
    			{
    				if(k!=j)
    				{
    					temp[j] = Math.max(temp[j], points[i][k]+dp[k]);
    				}
    			}
    		}
    		dp = temp.clone();
    	}
    	return dp[3];
    }

    public static void main(String[] args) {
    	int arr[][]  = {{10,50,1},{5,100,11}};
    	gfgGeeksTraining obj = new gfgGeeksTraining();
    	int res = obj.maximumPoints(arr, arr.length);
    	System.out.println(res);
    }
}