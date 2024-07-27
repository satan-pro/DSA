import java.util.*;
class lc416 // Partition Equal Subset Sum
{
	// Memoization Approach
	boolean findSum(int ind, int target, int[] nums, int dp[][])
	{
		if(target==0)
			return true;
		if(ind==0)
			return nums[ind]==target;
		if(dp[ind][target]!=-1)
			return dp[ind][target]==0?false:true;

		boolean notTake = findSum(ind-1, target, nums, dp);
		boolean take = false;
		if(nums[ind]<=target)
			take = findSum(ind-1, target-nums[ind], nums, dp);

		dp[ind][target] = take||notTake?1:0;
		return take||notTake;
	}

	public boolean canPartition1(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++)
        	sum+=nums[i];
        if(sum%2==1)
        	return false;

        int dp[][] = new int[nums.length][(sum/2)+1];

        for(int[] arr:dp)
        	Arrays.fill(arr,-1);

        boolean res = findSum(nums.length-1, sum/2, nums, dp);
        return res;
    }

    // Tabulation Approach
    public boolean canPartition2(int[] nums) {
    	int sum=0;
    	for(int i=0; i<nums.length; i++)
    		sum+=nums[i];
    	if(sum%2==1)
    		return false;

    	boolean dp[][] = new boolean[nums.length][(sum/2)+1];

    	if(nums[0]<=(sum/2)) // IMPORTANT : Base Case when nums[0] is less than equal to the remaining sum
    		dp[0][nums[0]]=true;

    	for(int i=1; i<nums.length; i++)
    	{
    		for(int j=0; j<dp[0].length; j++)
    		{
    			if(j==0)
    				dp[i][j]=true;
    			else 
    			{
    				boolean notPick = dp[i-1][j];
    				boolean pick=false;
    				if(nums[i]<=j)
    					pick = dp[i-1][j-nums[i]];
    				dp[i][j] = pick||notPick;
    			}
    		}
    	}
    	return dp[nums.length-1][sum/2];
    }

    // Space Optimization
    public boolean canPartition(int[] nums) {
    	int sum=0;
    	for(int i=0; i<nums.length; i++)
    		sum+=nums[i];
    	if(sum%2==1)
    		return false;

    	boolean dp[] = new boolean[(sum/2)+1];

    	if(nums[0]<=(sum/2))
    		dp[nums[0]]=true;

    	for(int i=1; i<nums.length; i++)
    	{
    		boolean curr[] = new boolean[dp.length];
    		for(int j=0; j<dp.length; j++)
    		{
    			if(j==0)
    				curr[j]=true;
    			else 
    			{
    				boolean notPick = dp[j];
    				boolean pick=false;
    				if(nums[i]<=j)
    					pick = dp[j-nums[i]];
    				curr[j] = pick||notPick;
    			}
    		}
    		dp = Arrays.copyOf(curr, curr.length);
    	}
    	return dp[sum/2];
    }
}