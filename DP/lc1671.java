import java.util.*;
class lc1671
{
	public int minimumMountainRemovals(int[] nums) {
        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        
        for(int i=0; i<nums.length; i++)
        {
        	for(int prev=0; prev<=i-1; prev++)
        	{
        		if(nums[prev]<nums[i])
        			dp1[i] = Math.max(dp1[i], 1+dp1[prev]);
        	}
        }

        for(int i=nums.length-1; i>=0; i--)
        {
        	for(int prev=nums.length-1; prev>=i+1; prev--)
        	{
        		if(nums[prev]<nums[i])
        			dp2[i] = Math.max(dp2[i], 1+dp2[prev]);
        	}
        }

        int ans=-1;
        for(int i=0; i<dp1.length; i++)
        {
        	ans = Math.max(ans, dp1[i]+dp2[i]-1);
        }

        return nums.length-ans;
    }
}