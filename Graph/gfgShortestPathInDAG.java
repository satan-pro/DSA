import java.util.*;
class gfgShortestPathInDAG 
{
	public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        int[] ans = new int[V];
        Arrays.fill(ans, -1);

        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0; i<V; i++)
        	adj.add(new ArrayList<>());

        for(int i=0; i<E; i++)
        	adj.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        ans[0] = 0;

        while(!q.isEmpty())
        {
        	int[] curr = q.poll();
        	int currNode = curr[0];
        	int currPath = curr[1];

        	for(int[] node: adj.get(currNode))
        	{
        		if(ans[node[0]]==-1 || currPath+node[1]<ans[node[0]])
        		{
        			ans[node[0]] = currPath+node[1];
        			q.offer(new int[]{node[0], ans[node[0]]});
        		}
        	}
        }

        return ans;
    }
}