import java.util.*;
class gfgFloorInSortedArray  // Floor in a Sorted Array
{
	// Intuition : Find the mid as the element which is smaller or equal to target
	// Check for an element larger than the current element that satisfies the condition
	// If element is larger than the target move to left
	// Loop terminates when low>high
	
	static int findFloor(long arr[], int n, long x) {
		int low = 0, high = arr.length;
		int ans = -1;
		while(low<=high)
		{
			int mid = (low+high)/2;
			
			if(arr[mid]>=x)
			{
				ans = mid;
				high = mid-1;
			}
			else 
				low = mid+1;
		}
		if(ans==0 && arr[0]>x)
			return -1;
		return ans;
	}
}