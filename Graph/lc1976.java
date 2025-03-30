import java.util.*;
class lc1976  // Number of Ways to reach Destination
{
	public int countPaths(int n, int[][] roads) {
		// Building the adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        	adj.add(new ArrayList<>());

        // Undirected graph 
        for(int i=0; i<roads.length; i++)
        {
        	adj.get(roads[i][0]).add(new int[]{roads[i][1], roads[i][2]});
        	adj.get(roads[i][1]).add(new int[]{roads[i][0], roads[i][2]});
        }

        // Array to store the djikstra distance
        long time[] = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);

        // Array to store the no of paths possible
        int paths[] = new int[n];
        Arrays.fill(paths, 0);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});
        time[0] = 0;
        paths[0] = 1;

        int mod = (int)(1e9+7);

        // classic djikstra algorithm
        while(!pq.isEmpty())
        {
        	long[] curr = pq.poll();
        	int currNode = (int)curr[0];
        	long dist = curr[1];

        	for(int[] next: adj.get(currNode))
        	{
        		// If the current distnace is less than already visited distance
        		if(dist + next[1] < time[next[0]])
        		{
        			time[next[0]] = dist + next[1];
        			pq.offer(new long[]{next[0], time[next[0]]});

        			// the no of paths for the current node will be the same as its previous node
        			paths[next[0]] = paths[currNode];
        		}
        		// if the distnace is the same, then we can count other paths we encountered
        		else if(dist + next[1] == time[next[0]])
        		{
        			// in this case the no of paths is the sum of the current node's paths and the no of ways to reach the previous node as well (ways[curr] = ways[curr] + ways[prev])
        			paths[next[0]] = (paths[next[0]] + paths[currNode])%mod;
        		}
        	}
        }

        return paths[n-1]%mod;
    }
}