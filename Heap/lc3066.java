import java.util.*;
class lc3066
{
	// Brute Force Approach
	public int minOperations1(int[] nums, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>();

        // Keep track of initial elements greater than k
        int kCount = 0;
        for(int n: nums)
        {
        	pq.offer((double)n);
        	if(n>=k)
        		kCount++;
        }

        // If all elements of the array>=k then return 0
        if(kCount==nums.length)
            return 0;
            
        int ans = 0;
        while(pq.size()>=2)
        {
        	double x = pq.poll();
        	double y = pq.poll();

        	double val = Math.min(x, y)*2 + Math.max(x, y);
        	pq.offer(val);

        	// Decrease kCount for an element >=k
        	if(x>=k)	
        		kCount--;
        	if(y>=k)
        		kCount--;
        	// Increase kCount for an element >=k
        	if(val>=k)
        		kCount++;

        	ans++;

        	// Check if the kCount is equal to the current size of the array, then break else continue
        	if(kCount==nums.length-ans)
        		break;
        }

        return ans;
    }

    // Better Approach
    public int minOperations(int[] nums, int k) {
    	PriorityQueue<Double> pq = new PriorityQueue<>();

    	for(int n: nums)
    		pq.offer((double)n);

    	int ans = 0;

    	// Check if the array contains 2 elements and if the smallest element is less than k, then loop in else break
    	while(pq.size()>=2 && pq.peek()<k)
    	{
    		double x = pq.poll();
    		double y = pq.poll();
    		double val = Math.min(x, y)*2 + Math.max(x, y);

    		pq.offer(val);
    		ans++;
    	}

    	return ans;   
    }
}