import java.util.*;
class gfgTopologicalSort
{	
	public static void dfs(int i, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] vis) {
		vis[i] = true;

		for(int node: adj.get(i))
		{
			if(!vis[node])
				dfs(node, adj, ans, vis);
		}

		ans.add(i);
	}
	static ArrayList<Integer> topologicalSort1(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        boolean vis[] = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<adj.size(); i++)
        {
        	if(!vis[i])
        		dfs(i, adj, ans, vis);
        }

        Collections.reverse(ans);
        return ans;
    }

    // BFS: Kahn's Algorithm
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
    	int[] indegree = new int[adj.size()];

    	// creating the indegree array
    	for(int i=0; i<adj.size(); i++)
    	{
    		for(int node: adj.get(i))
    			indegree[node]++;
    	}

    	Queue<Integer> q = new LinkedList<>();
    	for(int i=0; i<indegree.length; i++)
    		if(indegree[i]==0)
    			q.offer(i);

    	ArrayList<Integer> ans = new ArrayList<>();

    	// Kahn's algorithm
    	while(!q.isEmpty())
    	{
    		int curr = q.poll();
    		ans.add(curr);

    		// reduce the indegree of the adjacent nodes
    		for(int node: adj.get(curr))
    		{
    			indegree[node]--;
    			// if indegree of any node becomes 0, add it to the queue
    			if(indegree[node]==0)
    				q.offer(node);
    		}
    	}

    	return ans;
    }
}