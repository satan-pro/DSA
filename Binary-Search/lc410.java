import java.util.*;
class lc410
{
	boolean isValid(int[] nums, int t, int k)
	{
		int valSum=0;
		int count=1;
		for(int i=0; i<nums.length; i++)
		{
			if(valSum+nums[i]<=t)
				valSum+=nums[i];
			else 
			{
				count++;
				valSum=nums[i];
			}
			if(count>k)
				return false;
		}
		return count<=k;
	}
	public int splitArray(int[] nums, int k) {
        int low=Integer.MAX_VALUE;
        int high=0;
        for(int i:nums)
        {
        	high+=i;
        	low=Math.min(low, i);
        }

        int ans=0;
        while(low<=high)
        {
        	int mid=(low+high)/2;
        	if(isValid(nums, mid, k))
        	{
        		ans=mid;
        		high=mid-1;
        	}
        	else 
        		low=mid+1;
        }
        return ans;
    }
}