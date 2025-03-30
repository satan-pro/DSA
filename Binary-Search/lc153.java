import java.util.*;
class lc153
{	
	// Binary Search Algorithm
	public int findMin1(int[] nums) {
        int low=0, high=nums.length-1;
        int ans = Integer.MAX_VALUE;
        
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            // If the left half is sorted, the minimum must be in the right half, so low=mid+1
            // The lowest value for left half will be nums[low]
            if(nums[low]<=nums[mid])
            {
                ans = Math.min(ans, nums[low]);
                low = mid+1;
            }
            // If the right half is sorted, the minimum must be in the left half, so high=mid-1 
            // the lowest value in the right half will be nums[mid]
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }

    // Further Optimized Binary Search
    public int findMin(int[] nums) {
        int low=0, high=nums.length-1;
        int ans = Integer.MAX_VALUE;
        
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            // if the entire array is sorted, or atleast the current half is sorted then we find the lowest value in the array and update the answer
            // The reason we update the answer is because even if nums[low] is not the lowest value, the ans will store the lowest
            // Also in this case it doesnt need anymore mid calculation as the array under consideration is already sorted
            if(nums[low]<=nums[high])
            {
            	ans = Math.min(ans, nums[low]);
            	break;
            }

            // If the left half is sorted, the minimum must be in the right half, so low=mid+1
            // The lowest value for left half will be nums[low]
            if(nums[low]<=nums[mid])
            {
                ans = Math.min(ans, nums[low]);
                low = mid+1;
            }
            // If the right half is sorted, the minimum must be in the left half, so high=mid-1 
            // the lowest value in the right half will be nums[mid]
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}