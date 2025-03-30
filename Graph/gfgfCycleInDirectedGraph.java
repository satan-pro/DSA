import java.util.*;
class gfgCycleInDirectedGraph
{
	public boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
		vis[i] = true;
		pathVis[i] = true;

		boolean isCycle = false;

		for(int node: adj.get(i))
		{
			if(!vis[node])
				isCycle = isCycle || dfs(node, adj, vis, pathVis);
			else if(pathVis[node])
				return true;
		}
		pathVis[i] = false;
		return isCycle;
	}
	public boolean isCyclic1(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];

        for(int i=0; i<V; i++)
        {
        	if(!vis[i] && dfs(i, adj, vis, pathVis))
        		return true;
        }
        return false;
    }

    // BFS Solution : Kahn's Algorithm
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int indegree[] = new int[V];

        // create the indegree array
        for(int i=0; i<V; i++)
        {
        	for(int node: adj.get(i))
        		indegree[node]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // add all nodes to queue whose indegree is 0
        for(int i=0; i<V; i++)
        	if(indegree[i]==0)
        		q.offer(i);

        List<Integer> ans = new ArrayList<>();

        // perform topological sort using BFS traversal
        while(!q.isEmpty())
        {
        	int curr = q.poll();
        	ans.add(curr);

        	for(int node: adj.get(curr))
        	{
        		// reduce the indegree of adjacent nodes 
        		indegree[node]--;
        		// if indegree of any node reaches 0, add it to queue
        		if(indegree[node]==0)
        			q.offer(node);
        	}
        }

        // if ans does not contain all nodes of the graph, then topo sort wasnt possible
        // hence graph is cyclic; so return false
        return ans.size()<V;
    }
}