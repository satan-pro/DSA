import java.util.*;
class lc2208
{
	public int halveArray(int[] nums) {
		// Use double to avoid confusion of rounding values while halving the values
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        double ans = 0;
        for(int n: nums)
        {
        	pq.offer((double)n);
        	ans+=(double)n;
        }

        double target = ans/2.0;
        int k=0;
        while(ans>target)
        {
        	// Using double for halving the valued to maintain precision
        	double curr = pq.poll();
        	ans-=curr/2.0;
        	pq.offer(curr/2.0);
        	k++;
        }

        return k;
    }
}