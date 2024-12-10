import java.util.*;
class lc673
{
	public int findNumberOfLIS(int[] nums) {
        
        int dp[] = new int[nums.length];
        int cnt[] = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int maxi = 0;

        for(int i=0; i<nums.length; i++)
        {
        	for(int prev=0; prev<=i-1; prev++)
        	{
        		if(nums[i]>nums[prev] && dp[prev]+1>dp[i])
        		{
        			dp[i] = 1+dp[prev];
        			cnt[i] = cnt[prev];
        		}
        		else if(nums[i]>nums[prev] && dp[prev]+1==dp[i])
        			cnt[i]+=cnt[prev];
        	}
        	maxi = Math.max(maxi, dp[i]);
        }

        int res = 0;
        for(int i=0; i<dp.length; i++)
        {
        	if(dp[i]==maxi)
        		res+=cnt[i];
        }

        return res;
    }
}