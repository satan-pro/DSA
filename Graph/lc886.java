import java.util.*;
class lc886  // Possible Bipartition
{
	// DFS solution : same as bipartite graph
	public boolean dfs(int i, int grp, List<List<Integer>> graph, int[] vis) {
		// color the current node
		vis[i] = grp;

		for(int node: graph.get(i))
		{
			// if node is not coloured yet
			if(vis[node]==-1)
			{
				// check its dfs and return false if required
				if(!dfs(node, 1-grp, graph, vis))
					return false;
			}
			// if the color of neighbouring node is same as the color of current node, then graph is not bipartite
			// return false in this case
			else if(vis[node]==vis[i])
				return false;
		}
		// return true for all other cases
		return true;
	}
	public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] vis = new int[n+1];
        Arrays.fill(vis, -1);
        
        // Convert the array into an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++)
        {
        	graph.add(new ArrayList<>());
        }
        for(int[] arr: dislikes)
        {
        	graph.get(arr[0]).add(arr[1]);
        	graph.get(arr[1]).add(arr[0]);
        }

       	// perform dfs on each node of the graph, if they are not visited already
        for(int i=1; i<=n; i++)
        {
        	if(vis[i]==-1 && !dfs(i, 0, graph, vis))
        		return false;
        }
        return true;
    }
}