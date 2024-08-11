import java.util.*; 
class gfgBfsOfGraph  // BFS of Graph
{
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		boolean vis[] = new boolean[V];
		vis[0] = true;

		while(!q.isEmpty())
		{
			int curr = q.poll();
			ans.add(curr);

			for(Integer i : adj.get(curr))
			{
				if(!vis[i])
				{
					vis[i]=true;
					q.offer(i);
				}
			}
		}
		return ans;
    }
}