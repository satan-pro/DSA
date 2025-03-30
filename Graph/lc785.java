import java.util.*;
class lc785  // Is Graph Bipartite?
{
	// DFS solution
	public boolean dfs(int node, int prev, int[][] graph, int[] vis) {
		// Change the color of the current node according to its previous adjacent node
		vis[node] = prev==0?1:0;

		// stores the result of recursive calls as well
		boolean valid = true;

		// Traverse all nodes in the adjacency list
		for(int i=0; i<graph[node].length; i++)
		{
			// If node is not visited, visit and store the value in valid
            if(vis[graph[node][i]]==-1)
				valid = valid && dfs(graph[node][i], vis[node], graph, vis);
			// If adjacent node is already visited (i.e. cycle) and has same color as current node, it is bipartite
			// return false in such case
			else if(vis[graph[node][i]]==vis[node])
				return false;
		}
		return valid;
	}
	public boolean isBipartite(int[][] graph) {
        
        // Initialize vis with -1
        int vis[] = new int[graph.length];
        Arrays.fill(vis, -1);

        for(int i=0; i<graph.length; i++)
        {
        	// If node is not visited, check its dfs; if false, return false
        	if(vis[i]==-1 && dfs(i, 0, graph, vis)==false)
        		return false;
        }
        return true;
    }
}