import java.util.*;
class lc983
{
	// Memoization Approach
	public int findMinCost(int i, int[] days, int[] costs, int[] dp) {
		if(i>=days.length)
			return 0;
		if(dp[i]!=-1)
			return dp[i];

		// Option 1: Find cost for the current day
		int c1 = costs[0] + findMinCost(i+1, days, costs, dp);

		// Option 2: Find cost for 7-day pass
		int j=i;
		// Traverse through the days[] array and find the travel day in the array till which 7-day pass is valid 
		while(j<days.length && days[j]<days[i]+7)
			j++;
		int c2 = costs[1] + findMinCost(j, days, costs, dp);

		// Option 3: Find cost for the 30-day pass
		j=i;
		// Traverse the days[] array and find the last day for which 30-day pass is valid
		while(j<days.length && days[j]<days[i]+30)
			j++;
		int c3 = costs[2] + findMinCost(j, days, costs, dp);

		return dp[i] = Math.min(c1, Math.min(c2, c3));
	}
	public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length];

        Arrays.fill(dp, -1);

        int res = findMinCost(0, days, costs, dp);
        return res;
    }

    // Tabulation Approach
    public int mincostTickets1(int[] days, int[] costs) {
        int dp[] = new int[days.length+1];

        for(int i=days.length-1; i>=0; i--)
        {
        	// Option 1: 1 day pass
        	int c1 = costs[0] + dp[i+1];

        	// Option 2: 7 day pass
        	int j=i;
        	while(j<days.length && days[j]<days[i]+7)
        		j++;
        	int c2 = costs[1] + dp[j];

        	// Option 3: 30 day pass
        	j=i;
        	while(j<days.length && days[j]<days[i]+30)
        		j++;
        	int c3 = costs[2] + dp[j];

        	dp[i] = Math.min(c1, Math.min(c2, c3));
        }

        return dp[0];
    }
}