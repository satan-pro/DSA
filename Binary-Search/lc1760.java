import java.util.*;
class lc1760
{
	// find if the no of operations for the given answer
	public int findOps(int k, int[] nums) {
		int ops = 0;

		for(int i: nums)
		{
			// use Math.ceil() to account for the extra bags while distributing
			// example: if i=5 and k=2, it should divide into [2,2,1], i.e 3 bags, so use Math.ceil() to get ans 3 instead of 2
			int bags = (int)Math.ceil((double)i/k);
			ops += bags-1; // for each operation we produce 2 bags, hence ops = bags-1
		}
		return ops;
	}
	public int minimumSize(int[] nums, int maxOperations) {
        int low=1, high=Integer.MIN_VALUE;
        int res = 0;
        for(int i: nums)
        	high = Math.max(high, i);

        while(low<=high)
        {
        	int mid = (low+high)/2;
        	int ops = findOps(mid, nums);

        	// check if the no of operations exceed the maxOperations
        	if(ops>maxOperations)
        		low = mid+1;
        	else 
        	{
        		res = mid;
        		high = mid-1;
        	}
        }
        return res;
    }
}