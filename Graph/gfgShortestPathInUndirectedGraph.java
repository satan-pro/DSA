import java.util.*;
class gfgShortestPathInUndirectedGraph 
{
	// BFS Solution
	public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int[] ans = new int[adj.size()];
        Arrays.fill(ans, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        ans[src] = 0;

        while(!q.isEmpty())
        {
        	int currNode = q.poll();
        	int currPath = ans[currNode];

        	for(int node: adj.get(currNode))
        	{	
        		if(ans[node]==-1 || currPath+1<ans[node]) {
        			ans[node] = currPath+1;
        			q.offer(node);
        		}
        	}
        }
        return ans;
    }
}