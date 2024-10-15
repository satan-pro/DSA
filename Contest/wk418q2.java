import java.util.*;
class wk418q2
{
	public void dfs(int node, int prev, List<List<Integer>> adj, boolean vis[], boolean infected[], List<Integer> infectedNodes) {
		vis[node]=true;
		if(prev!=-1 && infected[prev])
			infected[node]=true;
		if(infected[node])
			infectedNodes.add(node);

		for(Integer i: adj.get(node))
		{
			if(!vis[i])
				dfs(i, node, adj, vis, infected, infectedNodes);
		}
	}
	public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean infected[] = new boolean[n];
        infected[k]=true;
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> parent = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
        	adj.add(new ArrayList<>());
        	parent.add(new ArrayList<>());
        	if(i!=k)
        		infected[i]=false;
        }
        for(int i=0; i<invocations.length; i++)
        {
        	adj.get(invocations[i][0]).add(invocations[i][1]);
        	parent.get(invocations[i][1]).add(invocations[i][0]);
        }

        // DFS Traversal
        List<Integer> infectedNodes = new ArrayList<>();
       boolean vis[] = new boolean[n];
       dfs(k,-1,adj,vis,infected, infectedNodes);

       boolean removal=false;
       for(Integer i: infectedNodes)
       {
       	for(Integer j: parent.get(i))
       	{
       		if(infected[j])
       			removal=true;
       	}
       }

       List<Integer> ans = new ArrayList<>();
       for(int i=0; i<n; i++)
       {
       		if(removal)
       		{
       			if(!infected[i])
       				ans.add(i);
       		}
       		else 
       		{
       			ans.add(i);
       		}
       }
       return ans;
    }
}