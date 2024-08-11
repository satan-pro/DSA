import java.util.*;
class ibConnectedComponents
{
	void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[])
	{
		vis[node]=true;

		for(Integer i : adj.get(node))
		{
			if(!vis[i])
				dfs(i, adj, vis);
		}
	}
	public int solve(int A, int[][] B) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int count=0;
		for(int i=0; i<=A; i++)
		{
			adj.add(new ArrayList<>());
		}
		for(int i=0; i<B.length; i++)
		{
			adj.get(B[i][0]).add(B[i][1]);
			adj.get(B[i][1]).add(B[i][0]);
		}

		boolean vis[] = new boolean[A+1];

		for(int i=1; i<=A; i++)
		{
			if(!vis[i])
			{
				dfs(i, adj, vis);
				count++;
			}
		}
		return count;
    }
}