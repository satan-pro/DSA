import java.util.*;
class lc2226  // Maximum Candies Allocated to K children
{
	// helper function to find if 'n' candies can be distributed among all
	public boolean isValid(int[] candies, long k, int n) {
		long count = 0;

		for(int num: candies)
			count+=(num/n);

		return count>=k;
	}
	public int maximumCandies(int[] candies, long k) {
		// Find the max candy pile in the array; make it as the high
        int maxCandy = Integer.MIN_VALUE;
        for(int n: candies)
        	maxCandy = Math.max(maxCandy, n);

        int low = 1, high = maxCandy;
        int ans = 0;

        // perform binary search on answers
        while(low<=high)
        {
        	int mid = (low+high)/2;

        	if(isValid(candies, k, mid))
        	{
        		// if valid candy found, mark it and proceed to find the maximum valid candy
        		ans = mid;
        		low = mid+1;
        	}
        	else 
        		high = mid-1;
        }

        return ans;
    }
}