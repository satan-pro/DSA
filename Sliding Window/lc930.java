import java.util.*;
class lc930 // Binary Subarrays with Sum k
{
	// Sliding Window with worst case TC-O(N^2)
	public int numSubarraysWithSum1(int[] nums, int goal) {
        int i=0, j=0, count=0, sum=0;
        while(j<nums.length)
        {
        	sum+=nums[j];
        	while(sum>goal)
        	{
        		sum-=nums[i];
        		i++;
        	}
        	if(sum==goal)
        	{
        		int temp=i;
        		while(temp<=j && sum==goal)
        		{
        			count++;
        			sum-=nums[temp];
        			temp++;
        		}
        		while(temp>i)
        		{
        			temp--;
        			sum+=nums[temp];
        		}
        	}
        	j++;
        }
        return count;
    }

    // This function finds no of subarrays less than or equal to the goal
    int findSubarrays(int nums[], int goal)
	{
		int i=0, j=0, count=0, sum=0;
		if(goal<0)
			return 0;
		while(j<nums.length)
		{
			sum+=nums[j];
			while(sum>goal)
			{
				sum-=nums[i];
				i++;
			}
			count+=j-i+1;
			j++;
		}
		return count;
	}

	// Sliding Window with worst case TC-O(4N)
	public int numSubarraysWithSum(int[] nums, int goal) {
		// To find the subarray that is exactly equal to the goal, use this formula: 
		// no of subarrays(<=goal) - no of subarrays(<=goal-1)
		int res = findSubarrays(nums, goal)-findSubarrays(nums, goal-1);
		return res;
	}

}	