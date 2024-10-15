import java.util.*;
class lc1283  // Find the Smallest divisor given a threshold
{
	boolean isValid(int[] nums, int k, int threshold)
	{
		int sum=0;
		for(int i:nums)
		{
			sum += Math.ceil((double)i/k);
		}
		return sum<=threshold;
	}
	public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high = Integer.MIN_VALUE;
        for(int i:nums)
        	high = Math.max(high, i);

        int ans=0;
        while(low<=high)
        {
        	int mid=(low+high)/2;
        	if(isValid(nums, mid, threshold))
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