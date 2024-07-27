import java.util.*;
class lc1004 // Max Consecutive Ones III
{
	public int longestOnes(int[] nums, int k) {
        int i=0, j=0;
        int zeroCount=0, maxCount=0;
        while(j<nums.length)
        {
        	if(nums[j]==0) // Increase Zerocount when there is 0
        		zeroCount++;

        	if(zeroCount>k) 
        	{
        		while(zeroCount>k) // If zeroCount is greater then move the window until it gets smaller
        		{
        			if(nums[i]==0) // Decrease zeroCount if zero is encountered while sliding window
        				zeroCount--;
        			i++;
        		}
        	}
        	if(zeroCount<=k) // Update max only when zeroCount is less than or equal to k
        		maxCount  = Math.max(maxCount, j-i+1);
        	j++;
        }
        return maxCount;
    }
}