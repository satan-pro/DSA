import java.util.*;
class lc300
{
	// Memoization Approach
	public int findMaxLen(int ind, int prev, int[] nums, int[][] dp) {
		if(ind==nums.length)
			return 0;
		if(dp[ind][prev+1]!=-1)
			return dp[ind][prev+1];

		int notTake = findMaxLen(ind+1, prev, nums, dp);
		int take = 0;
		if(prev==-1 || nums[ind]>nums[prev])
			take = 1+findMaxLen(ind+1, ind, nums, dp);

		dp[ind][prev+1] = Math.max(take, notTake);

		return dp[ind][prev+1];
	}
	public int lengthOfLIS1(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];

        for(int[] arr: dp)
        	Arrays.fill(arr, -1);

        int res = findMaxLen(0, -1, nums, dp);
        return res;
    }

    // Tabulation Approach
    public int lengthOfLIS2(int[] nums) {
    	int dp[][] = new int[nums.length][nums.length+1];

    	for(int i=nums.length-1; i>=0; i--)
    	{
    		for(int prev=i-1; prev>=-1; prev--)
    		{
    			int notPick = dp[i+1][prev+1];
    			int pick = 0;
    			if(prev==-1 || nums[i]>nums[prev])
    				pick = 1+dp[i+1][i+1];

    			dp[i][prev+1] = Math.max(pick, notPick);
    		}
    	}

    	return dp[0][0];
    }

    // The LIS approach
    public int lengthOfLIS3(int[] nums) {
    	int dp[] = new int[nums.length];

    	Arrays.fill(dp, 1);

    	for(int i=0; i<nums.length; i++)
    	{
    		for(int prev=0; prev<=i-1; prev++)
    		{
    			if(nums[prev]<nums[i])
    				dp[i] = Math.max(dp[i], 1+dp[prev]);
    		}
    	}

    	int ans=Integer.MIN_VALUE;
    	for(int n: dp)
    		ans = Math.max(ans, n);

    	return ans;
    }

    // Binary Search Method
    public int lengthOfLIS(int[] nums) {

    	ArrayList<Integer> res = new ArrayList<>();
    	for(int i=0; i<nums.length; i++)
    	{
    		if(res.size()==0 || nums[i]>res.get(res.size()-1))
    			res.add(nums[i]);
    		else 
    		{
    			int pos = Collections.binarySearch(res, nums[i]);
    			if(pos<0)
    				pos = Math.abs(pos)-1;
    			res.set(pos, nums[i]);
    		}
    	}

    	return res.size();
    }
}