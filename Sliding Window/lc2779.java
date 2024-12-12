import java.util.*;
class lc2779  // Maximum Beauty of an Array After Applying Operation
{
	public int maximumBeauty(int[] nums, int k) {
        int i=0, j=0;
        int maxCount = Integer.MIN_VALUE;
        Arrays.sort(nums);
        while(j<nums.length)
        {
        	while(nums[j]-nums[i]>2*k)
        		i++;

        	maxCount = Math.max(maxCount, j-i+1);
        	j++;
        }
        return maxCount;
    }
}