import java.util.*;
class lc210
{
	// BFS Solution : Kahn's algorithm
	public int[] findOrder1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj  = new ArrayList<>();

        // create the adjacency list
        for(int i=0; i<numCourses; i++)
        	adj.add(new ArrayList<>());
        for(int arr[]: prerequisites)
        	adj.get(arr[1]).add(arr[0]);

        // create the indegree array
        int[] indegree = new int[numCourses];
        for(int i=0; i<indegree.length; i++)
        {
        	for(int node: adj.get(i))
        		indegree[node]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // add the nodes to the queue whose indegree is 0
        for(int i=0; i<indegree.length; i++)
        	if(indegree[i]==0)
        		q.offer(i);

        List<Integer> values = new ArrayList<>();

        // perform topo sort using BFS (Kahn's algorithm)
        while(!q.isEmpty())
        {
        	int curr = q.poll();
        	values.add(curr);

        	for(int node: adj.get(curr))
        	{
        		indegree[node]--;
        		if(indegree[node]==0)
        			q.offer(node);
        	}
        }

        // if cycle exists in the graph, return empty array
        if(values.size()<numCourses)
        	return new int[]{};

        // transfer the result to an array and return the array
        int ans[] = new int[values.size()];

        for(int i=0; i<ans.length; i++)
        	ans[i] = values.get(i);

        return ans;
    }

    // DFS solution : using topo sort
    public boolean dfs(int i, List<List<Integer>> adj, List<Integer> ans, boolean[] vis, boolean[] pathVis) {
        vis[i] = true;
        pathVis[i] = true;

        // variable for checking cycle
        boolean isCycle = true;
        for(int node: adj.get(i))
        {
            if(!vis[node])
                // find cycle in the graph and store it 
                isCycle = isCycle && dfs(node, adj, ans, vis, pathVis);
            else if(pathVis[node])
                return false;
        }
        pathVis[i] = false;
        ans.add(i);
        return isCycle;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        // create adjacency list
        for(int i=0; i<=numCourses; i++)
            adj.add(new ArrayList<>());
        for(int[] arr: prerequisites)
            adj.get(arr[1]).add(arr[0]);
        
        List<Integer> ans = new ArrayList<>();

        boolean isValid = true;

        for(int i=0; i<numCourses; i++)
        {
            if(!vis[i])
                // check if the graph contains cycle
               isValid = isValid && dfs(i, adj, ans, vis, pathVis);
        }

        // if cycle found return empty array
        if(!isValid)
            return new int[]{};

        // transfer the items to an array and return the array
        int res[] = new int[ans.size()];
        int len = ans.size()-1;
        for(int i=0; i<=len; i++)
            res[i] = ans.get(len-i);

        return res; 
    }
}