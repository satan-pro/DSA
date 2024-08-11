import java.util.*;
class wk410q3 // LC:3250 Find the Count of Monotonic Pairs I
{
	// Intuition : For finding the monotnic pairs you need a 3d DP with [prev1][prev2][ind]
	// You need to iterate from prev1 to the number as the value cannot be larger than the number itself
	// The other half of the sum should be less than the previous other half, so check this condition
	// In the recurrence relation keep increasing the index of the array and check for validity
	int findCount(int prev1, int prev2, int ind, int n, int[] nums, int[][][] dp, int mod)
	{
		if(ind==n)
			return 1;
		if(prev2!=Integer.MAX_VALUE && dp[prev1][prev2][ind]!=-1)
			return dp[prev1][prev2][ind];

		int count=0;
		for(int i=prev1; i<=nums[ind]; i++)
		{
			int c1 = i;
			int c2 = nums[ind]-i;
			if(c2<=prev2)
				count = (count+findCount(c1, c2, ind+1, n, nums, dp, mod))%mod;
		}

		if(prev2!=Integer.MAX_VALUE)
			dp[prev1][prev2][ind]=count;
		
		return count;
	}
	public int countOfPairs(int[] nums) {
		int maxNum=Integer.MIN_VALUE;
		for(int n: nums)
			maxNum = Math.max(maxNum, n);

        int dp[][][] = new int[maxNum+1][maxNum+1][nums.length];

        for(int[][] arr1:dp)
        	for(int[] arr2: arr1)
        		Arrays.fill(arr2, -1);

        int mod = (int)(Math.pow(10, 9)+7);

        // Keep prev2 as Integer.MAX_VALUE
        // Reasons:
        // If prev2 = 0, then the condition in the findCount() method : c2<=prev2 will not work and result will always be 0
        // If prev2 = maxNum, then it will give output but gives TLE if it is not checked in the return dp[i][j][k] condition as it is a 3d DP
       	int res = findCount(0, Integer.MAX_VALUE, 0, nums.length, nums, dp, mod);
        return res;

    }
}