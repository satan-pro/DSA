import java.util.*;
class lc875  // Koko eating Bananas
{
	boolean isValid(int[] piles, int k, int h)
	{
		int count=0;
		for(int i=0; i<piles.length; i++)
		{
			count+=Math.ceil((double)piles[i]/k);
		}
		if(count<=h)
			return true;
		return false;
	}
	public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i:piles)
        {
        	high = Math.max(high, i);
        }
        int ans =0;
        while(low<=high)
        {
        	int mid = low+(high-low)/2;
        	if(isValid(piles, mid, h))
        	{
        		ans = mid;
        		high=mid-1;
        	}
        	else 
        		low=mid+1;
        }
        return ans;
    }
}