import java.util.*;
class lc1248 // Count Number of Nice Subarrays
{
	// Sliding Window to find the no of subarrays with odd numbers less than equal to k
	int findCount(int[] nums, int k)
	{
		int i=0, j=0, count=0, freq=0;
		if(k<0)
			return 0;
		while(j<nums.length)
		{
			if(nums[j]%2==1)
				freq++;
			while(i<=j && freq>k)
			{
				if(nums[i]%2==1)
					freq--;
				i++;
			}
			count+=j-i+1;
			j++;
		}
		return count;
	}
	public int numberOfSubarrays(int[] nums, int k) {
		// Finding the no of subarrays with k odd numbers
        int res = findCount(nums, k)-findCount(nums, k-1);
        return res;
    }
}