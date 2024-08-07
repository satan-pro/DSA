import java.util.*;
class lc1547  // Minimum Cost to Cut a Stick
{
	// Intuition : Cut the sticks by each element in the cuts array
	// Add 0 and n to the cuts array and sort the array
	// Create a dp array with the size of cuts[]
	// Inside the memoization function, make a cut at each possible position and add it and find the minimum of this cost

	// Memoization Approach
	int findMin(int i, int j, int cuts[], int dp[][])
	{
		if(i+1>=j)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];

		int cost = Integer.MAX_VALUE;
		for(int k=0; k<cuts.length; k++)
		{
			if(k>i && k<j)
				cost = Math. min(cost, cuts[j]-cuts[i] + findMin(i, k, cuts, dp)+findMin(k, j, cuts, dp));
		}
		
		return dp[i][j] = cost;
	}
	public int minCost(int n, int[] cuts) {
        int cuts2[] = new int[cuts.length+2];
        cuts2[0] = 0;
        cuts2[cuts2.length-1] = n;
        for(int i=0; i<cuts.length; i++)
        {
        	cuts2[i+1]=cuts[i];
        }
        Arrays.sort(cuts2);

        int dp[][] = new int[cuts2.length][cuts2.length];

        for(int[] arr: dp)
        	Arrays.fill(arr, -1);

        int res = findMin(0, cuts2.length-1, cuts2, dp);
        return res;
    }
}