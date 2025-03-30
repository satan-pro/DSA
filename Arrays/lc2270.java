import java.util.*;
class lc2270
{
	// Using a prefix array
	public int waysToSplitArray1(int[] nums) {
		// Prefix array to count the sum till 'i' index
        long[] prefix = new long[nums.length];

        for(int i=0; i<nums.length; i++)
        {
        	if(i>0)
        		prefix[i] = prefix[i-1];

        	prefix[i]+=nums[i];
        }

        int count=0;
        long totalSum = prefix[prefix.length-1];

        // Checking the condition given in the question
        for(int i=0; i<nums.length-1; i++)
        {
        	long left = prefix[i];
        	long right = totalSum-left;

        	if(left>=right)
        		count++;
        }

        return count;
    }

    // Without using prefix array
    public int waysToSplitArray(int[] nums) {
    	// Using currSum to compute the leftSum and totalSum to compute the rightSum
    	long currSum = 0;
    	long totalSum = 0;

    	for(int n: nums)
    		totalSum+=n;

    	int count=0;
    	for(int i=0; i<nums.length-1; i++)
    	{	
    		// Find the sum of elements till index 'i' i.e. leftSum
    		currSum+=nums[i];
    		// Finding rightSum from the totalSum
    		long rightSum = totalSum - currSum;

    		// Count the no of valid index
    		if(currSum>=rightSum)
    			count++;
    	}

    	return count;
    }
}