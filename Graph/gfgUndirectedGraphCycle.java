import java.util.*;
class gfgUndirectedGraphCycle  // Undirected Graph Cycle
{
	class Pair
	{
		int dest;
		int source;
		public Pair(int a, int b)
		{
			dest=a;
			source=b;
		}
	}

	// Using BFS Traversal

	// Intuition : Start by adding the first node in a queue in the form of <destination, source> 
	// Dequeue and traverse through the connected nodes of the current node
	// Add the node only if it is not visited
	// When dequeing the node, if the node is already visited then it represents a cycle; return false
	// Otherwise return true
	public boolean isCycle1(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        boolean vis[] = new boolean[V];

        for(int i=0; i<V; i++)
        {
        	if(!vis[i])
        	{
        		q.offer(new Pair(i, -1));
        	}
        	while(!q.isEmpty())
        	{
        		Pair curr = q.poll();
        		int dest = curr.dest;

        		if(vis[dest])
        			return false;

        		vis[dest]=true;

        		for(Integer k : adj.get(dest))
        		{
        			if(!vis[k])
        				q.offer(new Pair(k, dest));
        		}
        	}
        }
        return true;
    }

    // Using DFS Traversal (IMPORTANT)

    // Intuition : Pass the unvisited nodes to the dfs() method 
    // Traverse through the connected nodes of the current node and add them to the dfs
    // If the adjacent node is already visited, then check if it is equal to the parent 
    // Equal to parent => Not a Cycle ; Not equal to Parent => Cycle exists
    // If any dfs recursion call returns true, then return true in general 
    boolean dfs(int node, int source, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
    {
    	vis[node] = true;

    	for(Integer i : adj.get(node))
    	{
    		if(!vis[i])
    		{
    			if(dfs(i, node, vis, adj))
    				return true;
    		}
    		else if(i!=source)
    			return true;
    	}
    	return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    	boolean vis[] = new boolean[V];
    	for(int i=0; i<V; i++)
    	{
    		if(!vis[i])
    		{
    			if(dfs(i, -1, vis, adj))
    				return true;
    		}
    	}
    	return false;
    }
}