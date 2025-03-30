import java.util.*;
class lc2466  // Count Ways to Build Good Strings
{
	int mod = (int)(1e9 + 7);
	public int findStrings(int ind, int low, int high, int zero, int one, int[] dp) {
		if(ind>high)
			return 0;
		if(ind==high)
			return 1;
		if(dp[ind]!=-1)
			return dp[ind];

		int zeroPath = 0, onePath = 0;
		int count = 0;

		// Count the current string if it falls under the valid constraints
		if(ind>=low && ind<=high)
			count++;

		// Check if adding the zero exceeds the limit and then perform a recursion on that
		if(ind+zero<=high)
			zeroPath = findStrings(ind+zero, low, high, zero, one, dp)%mod;

		// Check if adding the one exceeds the limit and perform recursion
		if(ind+one<=high)
			onePath = findStrings(ind+one, low, high, zero, one, dp)%mod;

		// Add all the possible values to the current index
		return dp[ind] = (count+zeroPath+onePath)%mod;
	}
	public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high+1];

        Arrays.fill(dp, -1);

        int res = findStrings(0, low, high, zero, one, dp);
        return res;
    }
}