import java.util.*;
class lc2035
{
	public int minimumDifference(int[] nums) {
        
        int sum=0;
        for(int i=0; i<nums.length; i++)
        	sum+=nums[i];

        boolean dp[][] = new boolean[nums.length][sum+1];

        if(nums[0]<=sum)
        	dp[0][nums[0]]=true;

        for(int i=1; i<nums.length; i++)
        {
        	for(int j=0; j<=sum; j++)
        	{
        		if(j==0)
        			dp[i][j]=true;
        		else 
        		{
        			boolean notPick = dp[i-1][j];
        			boolean pick = false;
        			if(nums[i]<=j)
        				pick = dp[i-1][j-nums[i]];

        			dp[i][j] = pick||notPick;
        		}
        	}
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=sum; i++)
        {
        	if(dp[nums.length-1][i])
        	{
        		int diff = Math.abs(i-(sum-i));
        		min = Math.min(min, diff);
        	}
        }
        return min;
    }
}