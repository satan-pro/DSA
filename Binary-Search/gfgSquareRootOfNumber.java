import java.util.*;
class gfgSquareRootOfNumber
{
	long square(long n)
	{
		return n*n;
	}
	long floorSqrt(long n) {
        // Your code here
        int low=1, high=(int)n;
        long ans=0;
        while(low<=high)
        {
        	long mid = (low+high)/2;
        	if(square(mid)<=n)
        	{
        		ans=mid;
        		low = (int)(mid+1);
        	}
        	else 
        		high = (int)(mid-1);
        }
        return ans;
    }
}