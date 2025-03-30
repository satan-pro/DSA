import java.util.*;
class gfgBellmanFord
{
	static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int dist[] = new int[V];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;	

        // N-1 iterations of all the given edges
        for(int i=1; i<=V-1; i++)
        {
        	for(int edge[]: edges) {
        		int node1 = edge[0];
        		int node2 = edge[1];
        		int wt = edge[2];

        		if(dist[node1]!=1e9 && dist[node1] + wt < dist[node2]) {
        			dist[node2] = dist[node1] + wt;
        		}
        	}
        }

        // Nth iteration to check for negative cycle in the graph
        for(int edge[]: edges) {
        	int node1 = edge[0];
        	int node2 = edge[1];
        	int wt = edge[2];

        	if(dist[node1]!=1e9 && dist[node1]+wt<dist[node2]) {
        		return new int[]{-1};
        	}
        }

        return dist;
    }
}