import java.util.*;
class gfgDfsOfGraph
{
	void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans)
	{
		vis[node]=true;
		ans.add(node);

		for(Integer i : adj.get(node))
		{
			if(!vis[i])
				dfs(i, vis, adj, ans);
		}
	}
	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
		ArrayList<Integer> ans = new ArrayList<>();
		boolean vis[] = new boolean[V];
		dfs(0, vis, adj, ans);
		return ans;
    }
}