import java.util.*;
class lc207  // Course Schedule
{
	// DFS Solution : finding cycle in directed graph
	public boolean dfs(int i, List<List<Integer>> graph, boolean[] vis, boolean[] pathVis) {
		// mark visited and pathVis true for the current node
		vis[i] = true;
		pathVis[i] = true;

		boolean isCycle = false;
		// Traverse through adjacent nodes
		for(int node: graph.get(i))
		{
			if(!vis[node])
				// if adjacent node is not visited =, visit and check if it contains any cycle further or not
				isCycle = isCycle || dfs(node, graph, vis, pathVis);
			// if any adjacent node was already visited while travelling the current path, then cycle exists
			// return true in such case
			else if(pathVis[node])
				return true;
		}
		// while backtracking, mark the current node's pathVis = false
		pathVis[i] = false;
		return isCycle;
	}
	
	public boolean canFinish1(int numCourses, int[][] prerequisites) {
        boolean vis[] = new boolean[numCourses];
        boolean pathVis[] = new boolean[numCourses];

        // create the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
        	graph.add(new ArrayList<>());
        for(int i=0; i<prerequisites.length; i++)
        	graph.get(prerequisites[i][1]).add(prerequisites[i][0]);

        // check for each node in the graph
        for(int i=0; i<numCourses; i++)
        {
        	// if node not visited and cycle exists in current path, then course schedule is not valid; return false
        	if(!vis[i] && dfs(i, graph, vis, pathVis))
        		return false;
        }
        // return true for all other schedules
        return true;
    }

    // BFS algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     	// indegree array to calculate the indegree of the nodes
     	int indegree[] = new int[numCourses];

     	// creating the adjacency list for the graph
     	List<List<Integer>> adj = new ArrayList<>();
     	for(int i=0; i<numCourses; i++)
     		adj.add(new ArrayList<>());
     	for(int i=0; i<prerequisites.length; i++)
     	{
     		adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
     		indegree[prerequisites[i][0]]++;
     	}   

     	Queue<Integer> q = new LinkedList<>();
     	// add all the indegree 0 nodes to the queue 
     	for(int i=0; i<indegree.length; i++)
     		if(indegree[i]==0)
     			q.offer(i);

     	List<Integer> ans = new ArrayList<>();
     	// Kahn's Algorithm
     	while(!q.isEmpty())
     	{
     		int curr = q.poll();
     		ans.add(curr);

     		for(int i: adj.get(curr))
     		{
     			indegree[i]--;
     			if(indegree[i]==0)
     				q.offer(i);
     		}
     	}

     	// if ans size is less than no of nodes, then graph is not acyclic
     	return ans.size()==numCourses;
    }
}