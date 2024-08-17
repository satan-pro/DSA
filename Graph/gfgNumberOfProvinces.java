import java.util.*;
class gfgNumberOfProvinces  // Number of Provinces
{
	// DFS Traversal for traversing through the component
	static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
	{
		vis[node]=true;

		for(int i=0; i<adj.get(node).size(); i++)
		{
			if(!vis[i] && adj.get(node).get(i)==1)
			{
				dfs(i, vis, adj);
			}
		}
	}
	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean vis[] = new boolean[V];
        int count=0;

        // Loop for traversing each node in the graph
        for(int i=0; i<V; i++)
        {
        	// If the node is not visited, then it represents new province, increase count
        	if(!vis[i])
        	{
        		count++;
        		dfs(i, vis, adj);
        	}
        }
        return count;
    }
}