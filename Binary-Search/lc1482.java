import java.util.*;
class lc1482  // Minimum days to make M bouquets
{
	// Function to check the no of bouquets formed
	boolean isValid(int[] bloomDay, int n, int m, int k)
	{
		int flowers=0;
		int count=0;

		// Sliding window to find no of adjacent flowers and respectiv bouquets
		for(int i=0; i<bloomDay.length; i++)
		{
			if(bloomDay[i]<=n)
			{
				flowers++;
				if(flowers==k)
				{
					// If flower equals k, increase bouquet count
					count++;
					flowers=0;
				}
			}
			else 
				flowers=0;
		}
		return count>=m;
	}
	public int minDays(int[] bloomDay, int m, int k) {
		if(bloomDay.length<(m*k))
			return -1;

        int low=Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i:bloomDay)
        {
        	low = Math.min(low, i);
        	high = Math.max(high, i);
        }
        int ans =0;

        // Binary search to find the minimum day
        while(low<=high)
        {
        	int mid = (low+high)/2;
        	if(isValid(bloomDay, mid, m, k))
        	{
        		ans=mid;
        		high=mid-1;
        	}
        	else 
        		low=mid+1;
        }
        return ans>0?ans:-1;
    }
}