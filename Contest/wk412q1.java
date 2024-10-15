import java.util.*;
class wk412q1
{
	class Pair
	{
		long n;
		int ind;
		public Pair(long a, int b)
		{
			n=a;
			ind=b;
		}
	}
	long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
	public int[] getFinalState(int[] nums, int k, int multiplier) {
		final int mod = (int)(Math.pow(10,9)+7);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->{
        	int v = Long.compare(x.n,y.n);
        	if(v==0)
        		return Integer.compare(x.ind, y.ind);
        	return v;
        });

        for(int i=0; i<nums.length; i++)
        {
        	pq.offer(new Pair((long)nums[i], i));
        }

        while(k>0)
        {
        	Pair curr = pq.poll();
        	long minValue = curr.n;

        	long nextValue = pq.isEmpty() ? Long.MAX_VALUE : pq.peek().n;
            long operations = Math.min(k, (nextValue - 1) / minValue + 1);
            long updatedValue = (minValue * modPow(multiplier, operations, mod)) % mod;

            // Update the minimum element in the array
            nums[curr.ind] = (int) updatedValue;
            k -= operations;

        	pq.offer(new Pair((long)(nums[curr.ind]), curr.ind));
        }

        return nums;
    }

    public int[] getFinalState1(int[] nums, int k, int multiplier) {
    	int min = nums[0];
    	while(k>0)
    	{
    		int ind=0;
    		for(int i=1; i<nums.length; i++)
    		{
    			if(nums[i]<min)
    			{
    				min=nums[i];
    				ind=i;
    			}
    		}

    		nums[ind] = nums[ind]*multiplier;
    		k--;
    	}
    	return nums;
    }
}