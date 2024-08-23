import java.util.*;
class lc719  // Find K-th Smallest Pair Distance
{
	// Brute Force Solution
	 public int smallestDistancePair1(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length-1; i++)
        {
        	for(int j=i+1; j<nums.length; j++)
        	{
        		list.add(Math.abs(nums[i]-nums[j]));
        	}
        }

        Collections.sort(list);

        return list.get(k-1);
    }

    // Binary Search with Sliding Window Technique

    // Intuition : Find the required difference between the pairs using binary search
    // Take the low as 0 and high as the max differnce between the min and max element in the array
    // Binary search through this search space
    // Slide through the window and count the number of pairs that satisfy the specified difference of numbers
    int findPairs(int[] nums, int k)
    {
    	int i=0, j=0;
    	int count=0;
    	while(j<nums.length)
    	{
    		while(Math.abs(nums[j]-nums[i])>k)
    		{
    			i++;
    		}
            count+=j-i;
    		j++;
    	}
    	return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
    	int low=0, high = nums[nums.length-1]-nums[0];

    	while(low<high)
    	{
    		int mid = (low+high)/2;
    		int count = findPairs(nums, mid);
    		if(count<k)
    		    low = mid+1;
            else 
                high = mid;
    	}
    	return low;
    }
}