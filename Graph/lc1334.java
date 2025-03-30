import java.util.*;
class lc1334  // Find the City With the Smallest Number of Neighbors at a Threshold Distance
{
	// djikstra algorithm for a particular start node 
	 public int findReachableCities(int n, ArrayList<ArrayList<int[]>> adj, int start, int k) {
		boolean[] vis = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{start, 0});
        
        int reachableCities = 0;

        // this finds the no of permissible adjacent nodes
        // so we need to maintain a vis array to avoid infinite recursion (since it is an undirected graph)
        while(!pq.isEmpty())
        {
        	int[] pair = pq.poll();
        	int currNode = pair[0];
        	int currDist = pair[1];

        	// only if the current Node is not visited it goes through the djikstra algo
        	if(!vis[currNode])
        	{
        		vis[currNode] = true;
	        	reachableCities++;

	        	for(int[] next: adj.get(currNode))
	        	{
	        		int nextDist = currDist + next[1];
	        		if(nextDist <= k)
	        		{
	        			pq.offer(new int[]{next[0], nextDist});
	        		}
	        	}
        	}
        }

        return reachableCities-1;
	}
	public int findTheCity1(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0; i<n; i++)
        	adj.add(new ArrayList<>());

        // create an undirected graph
        for(int i=0; i<edges.length; i++)
        {
        	adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
        	adj.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }

        int minNeighbours = Integer.MAX_VALUE;
        int ans = -1;

        // find the permissible neighbour cities for each node
        for(int i=0; i<n; i++)
        {
        	int neighbours = findReachableCities(n, adj, i, distanceThreshold);

        	// get the minimum neighbours for all nodes
        	if(neighbours <= minNeighbours)
        	{
        		minNeighbours = neighbours;
        		// update answer to contain the largest value node with minimum neighbours
        		ans = i;
        	}
        }

        return ans;
    }

    // Using Floyd-Warshall algorithm
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        for(int[] arr: mat)
            Arrays.fill(arr, (int)(1e8));

        // Build the adjacency matrix
        for(int i=0; i<edges.length; i++)
        {
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];

            mat[src][dest] = wt;
            mat[dest][src] = wt;
        }

        // Apply Floyd-Warshall algorithm 
        // Here all nodes to all nodes are considered, hence we can use Floyd-Warshall for this question
        for(int k=0; k<n; k++) 
        {
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<n; j++)
                {
                    if(i==j)
                        mat[i][j] = 0;

                    mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                }
            }
        }

        int bestCity = -1;
        int cityCount = n;

        // find the city with smallest no of nodes < distanceThreshold
        // update the bestCity by the largest city
        for(int i=0; i<n; i++) 
        {
            int currCount = 0;
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] <= distanceThreshold)
                    currCount++;
            }

            if(currCount<=cityCount)
            {
                cityCount = currCount;
                bestCity = i;
            }
        }

        return bestCity;
    }
}