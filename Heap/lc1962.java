import java.util.*;
class lc1962
{
	// TC: O(3N)
	public int minStoneSum1(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n: piles)
        	pq.offer(n);

        for(int i=0; i<k; i++)
        {
        	int curr = pq.poll();
        	pq.offer(curr-(int)Math.floor(curr/2.0));
        }

        int ans = 0;
        while(!pq.isEmpty())
        	ans+=pq.poll();

        return ans;
    }

    // TC: O(2N)
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int ans=0;
        for(int n: piles)
        {
        	pq.offer(n);
        	ans+=n;
        }

        for(int i=0; i<k; i++)
        {
        	int curr = pq.poll();
        	int rem = (int)Math.floor(curr/2.0);
        	ans-=rem;
        	pq.offer(curr-rem);
        }

        return ans;
    }
}