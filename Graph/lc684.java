import java.util.*;
class lc684  // Redundant Connection
{
	// DFS cycle detection in a graph
	public boolean dfs(int i, int source, List<List<Integer>> adj, boolean[] vis) {
		vis[i] = true;

		for(int node: adj.get(i))
		{
			if(!vis[node])
			{
				if(dfs(node, i, adj, vis))
					return true;
			}
			else if(node!=source)
				return true;
		}
		return false;
	}
	public int[] findRedundantConnection(int[][] edges) {
        boolean[] vis = new boolean[edges.length+1];
        List<List<Integer>> adj = new ArrayList<>();
        
        // Initializing the adjacency list
        for(int i=0; i<=edges.length; i++)
            adj.add(new ArrayList<>());

        int ans[] = new int[2];

        for(int i=0; i<edges.length; i++)
        {
        	// creating the adjacency list for each edge that is encountered
        	adj.get(edges[i][0]).add(edges[i][1]);
        	adj.get(edges[i][1]).add(edges[i][0]);

        	// re-initilaizing the visited array to check for cycles
        	Arrays.fill(vis, false);

        	// if the currently added edge creates a cycle, then this edge is the answer, return it
        	if(dfs(edges[i][0], -1, adj, vis))
        		return edges[i];
        }
        return ans;
    }
}