import java.util.*;
class lc1011  // Capacity to ship packages within D days
{
	boolean isValid(int[] weights, int k, int days)
	{	
		// Keep count=1 as counting will start from day 1 and not day 0
		int count=1;
		int valSum=0;
		for(int i=0; i<weights.length; i++)
		{
			// Check if curr weight can be added to curr day
			if(valSum+weights[i]<=k)
				valSum+=weights[i];
			else 
			{
				// Increase count for a new day
				count++;
				// Set the weight of new day as curr weight
				valSum=weights[i];
			}
			if(count>days)
				return false;
		}
		return count<=days;
	}
	public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i:weights)
        {
        	// The lowest value should be the max elem in the array
        	// Reason : The ship has to take atleast one package in a day
        	low = Math.max(low, i);
        	high+=i;
        }

        int ans=0;

        //Binary Search for the answer
        while(low<=high)
        {
        	int mid = (low+high)/2;
        	if(isValid(weights, mid, days))
        	{
        		ans=mid;
        		high=mid-1;
        	}
        	else 
        		low=mid+1;
        }
        return ans;
    }
}