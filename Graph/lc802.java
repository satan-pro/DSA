import java.util.*;
class lc802
{
	public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdegree = new int[graph.length];
       	List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++)
        	adj.add(new ArrayList<>());

        for(int i=0; i<graph.length; i++)
        {
        	for(int node: graph[i])
        		adj.get(node).add(i);

        	outdegree[i] = graph[i].length;
        	if(outdegree[i]==0)
        	{
        		q.offer(i);
        	}
        }

        while(!q.isEmpty())
        {
        	int curr = q.poll();
        	ans.add(curr);

        	for(int node: adj.get(curr))
        	{
        		outdegree[node]--;
        		if(outdegree[node]==0)
        			q.offer(node);
        	}
        }

        Collections.sort(ans);
        return ans;
    }
}