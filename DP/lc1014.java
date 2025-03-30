import java.util.*;
class lc1014
{
    // DP Approach - Memoization : TLE
    public int findMax(int i, int[] values, int[] dp) {
        if(i==0)
            return  Integer.MIN_VALUE;
        if(dp[i]!=-1)
            return dp[i];

        int currBest = Integer.MIN_VALUE;

        for(int j=0; j<i; j++)
        {
            currBest = Math.max(currBest, values[j]+values[i]+j-i);
        }

        dp[i] = Math.max(currBest, findMax(i-1, values, dp));
        return dp[i];
    }
	public int maxScoreSightseeingPair1(int[] values) {
       
        int dp[] = new int[values.length];

        Arrays.fill(dp, -1);

        int res = findMax(values.length-1, values, dp);
        return res;
    }

    public int maxScoreSightseeingPair(int[] values) {
        int maxLeft = values[0];
        int ans = Integer.MIN_VALUE;

        // for a pair (i,j) we need to calculate values[i] + values[j] + i - j, where i<j
        // we divide the values into left and right parts 
        // the left part contains the terms with smaller index (maxLeft) : values[i] + i
        // the right part will contain the terms with higher index : values[j] - j
        for(int j=1; j<values.length; j++)
        {
            // find the ans for the pair (i,j) i.e. finding maxLeft + maxRight
            // maxRight = values[j] - j
            ans = Math.max(ans, maxLeft+values[j]-j);

            // we also find the maxLeft value for each index simultaneously, i.e. values[i] + i
            maxLeft = Math.max(maxLeft, values[j]+j);
        }

        return ans;
    }
}