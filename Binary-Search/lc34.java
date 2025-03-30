import java.util.*;
class lc34  // Find First and Last Position of Element in Sorted Array
{
	public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int begin = nums.length;
        int end = -1;

        // search for the begin of the target in the array
        while(low<=high)
        {
        	int mid = low+(high-low)/2;

        	if(nums[mid]<target)
        		low = mid+1;
        	else if(nums[mid]>target)
        		high = mid-1;
        	else {
        		begin = Math.min(begin, mid);
        		high = mid-1;
        	}
        }

        // reset low and high values
        low = 0;
        high = nums.length-1;
        
        // search for the end of the target in the array
        while(low<=high)
        {
        	int mid = low+(high-low)/2;

        	if(nums[mid]<target)
        		low = mid+1;
        	else if(nums[mid]>target)
        		high = mid-1;
        	else {
        		end = Math.max(end, mid);
        		low = mid+1;
        	}
        }

        // reset begin to -1 if not found
        if(begin==nums.length)
        	begin = -1;

        return new int[]{begin, end};
    }
}