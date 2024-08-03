import java.util.*;
class lc2134  // Minimum Swaps to group all Ones Together II
{
	// Intuition : The number of 1s in the array always remains the same
	// So the no of swaps required for a particular subarray will be the no of 0s in that subarray

	public int minSwaps(int[] nums) {
		int total = Arrays.stream(nums).sum();
		int doubleArr[] = new int[2*nums.length]; // Create a double array to handle circular nature

		for(int i=0; i<doubleArr.length; i++)
		{
			doubleArr[i] = nums[i%nums.length];
		}

		int j=0, i=0;
		int zeroCount=0;
		int minSwaps = Integer.MAX_VALUE;

		while(j<doubleArr.length)
		{
			if(doubleArr[j]==0) // Increase zeroCount if zero is found
				zeroCount++;

			while((j-i+1)>total) // Shrink the window is size is greater than total no of 1s
			{
				if(doubleArr[i]==0) // Decrease zeroCount if zero is found
					zeroCount--;
				i++;
			} 
			if((j-i+1)==total) 
				// The zeroCount becomes the answer for that subarray
				minSwaps  = Math.min(minSwaps, zeroCount);
			j++;
		}
		return minSwaps;   
    }
}