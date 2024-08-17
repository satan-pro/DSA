import java.util.*;
class lc35
{
	public int searchInsert(int[] nums, int target) {
        int low=0, high=nums.length-1;

        if(target<nums[0])
        	return 0;
        int ans = -1;
        
        while(low<=high)
        {
        	int mid = (low+high)/2;
        	if(nums[mid]==target)
        		return mid;
        	else if(nums[mid]<target)
        	{
        		ans = mid+1;
        		low = mid+1;
        	}
        	else 
        		high = mid-1;
        }
        return ans;
    }
}