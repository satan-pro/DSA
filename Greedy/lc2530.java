import java.util.*;
class lc2530
{
	public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int i=0; i<nums.length; i++)
        	pq.offer(nums[i]);

        long res=0;

        for(int i=0; i<k; i++)
        {
        	int currMax = pq.poll();
        	System.out.println(currMax);
        	res+=currMax;
        	int newCurr = (int)(Math.ceil(currMax/3.0));
        	pq.offer(newCurr);
        }
        return res;
    }
}