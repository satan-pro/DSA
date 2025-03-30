import java.util.*;
class gfgDijkstraAlgorithm
{
	class Pair {
		int d;
		int n;

		public Pair(int a, int b) {
			d = a;
			n = b;
		}
	}
	ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int n = adj.size();

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)->x.d-y.d);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new Pair(0, src));

        while(!pq.isEmpty())
        {
        	Pair curr = pq.poll();
        	int node = curr.n;
        	int dis = curr.d;

        	for(iPair next: adj.get(node))
        	{
        		int nextNode = next.first;
        		int nextDist = next.second;

        		if(dis + nextDist < dist[nextNode])
        		{
        			dist[nextNode] = dis + nextDist;
        			pq.offer(new Pair(dist[nextNode], nextNode));
        		}
        	}
        }

       ArrayList<Integer> ans = new ArrayList<>();
       for(int i=0; i<n; i++)
       	ans.add(dist[i]);

       return ans;
    }
}