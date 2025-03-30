import java.util.*;
class lc743  // Network Delay Time
{
	public int networkDelayTime(int[][] times, int n, int k) {
		// Build the adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        // Note : nodes are from 1 to n (so include n)
        for(int i=0; i<=n; i++)
        	adj.add(new ArrayList<>());

        for(int i=0; i<times.length; i++)
        {
        	adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        // Create the result array to store the distance for each node
        int res[] = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);

        // Prioirty Queue for djikstra algo
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k, 0});
        res[k] = 0;

        // classic Djikstra's algorithm
        while(!pq.isEmpty())
        {
        	int[] curr = pq.poll();
        	int currNode = curr[0];
        	int dist = curr[1];

        	for(int[] next: adj.get(curr[0]))
        	{
        		if(dist + next[1] < res[next[0]])
        		{
        			res[next[0]] = dist+next[1];
        			pq.offer(new int[]{next[0], dist+next[1]});
        		}
        	}
        }

        // Find the max of all the time taken to reach each node (that is the answer)
        int ans = Integer.MIN_VALUE;
        // Remeber to exclude node 0 as it is not present in the question constraint and will give error
        for(int i=1; i<res.length; i++)
        {
        	if(res[i]==Integer.MAX_VALUE)
        		return -1;
                
        	ans = Math.max(ans, res[i]);
        }

        return ans;
    }
}