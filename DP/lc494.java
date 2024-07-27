import java.util.*;
class lc494 // Target Sum
{
	int findCount(int ind, int target, int[] nums, int[][] dp)
	{
		if(ind==0)
		{
			if(target==0 && nums[ind]==0)
				return 2;
			else if(target==0 && nums[ind]!=0)
				return 1;
			else if(target==nums[ind])
				return 1;
			else
				return 0;
		}
		if(dp[ind][target]!=-1)
			return dp[ind][target];
		
		int pick=0;
		if(nums[ind]<=target)
			pick = findCount(ind-1, target-nums[ind], nums, dp);
		int notPick = findCount(ind-1, target, nums, dp);
		return dp[ind][target] = pick+notPick;
	}
	public int findTargetSumWays(int[] nums, int target) {
		int totSum = Arrays.stream(nums).sum();
		if(totSum<target)
			return 0;
		int targetSum = (totSum-target)/2;
		if((totSum-target)%2==0)
			return 0;

        int dp[][] = new int[nums.length][targetSum+1];

        for(int[] arr:dp)
        	Arrays.fill(arr, -1);

        int res = findCount(nums.length-1, targetSum, nums, dp);
        return res;
    }
}