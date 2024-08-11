import java.util.*;
class lc547  // Number of Provinces
{
	//Intuition : Iterate through all nodes in the graph and pick a traversal (DFS/BFS)
	// Maintain a visited array and allow nodes to be traversed only if they are not visited
	// Increase count of provinces when you encounter a node which is not visited (i.e. a new province)
	public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Converting the Adjacency Matrix to List
        for(int i=0; i<isConnected.length; i++)
        	adj.add(new ArrayList<>());

        for(int i=0; i<isConnected.length; i++)
        {
        	for(int j=0; j<isConnected[i].length; j++)
        	{
        		if(isConnected[i][j]==1 && i!=j)
        			adj.get(i).add(j);
        	}
        }

        // Creating Queue and visited array for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[isConnected.length];
        int count=0;

        // Iterate through each node in the graph
        for(int i=0; i<isConnected.length; i++)
        {
        	if(!vis[i])
        	{	
        		// Add node to queue only if it is not visited
        		q.offer(i);
        		vis[i]=true;
        		// Increase count of provinces if the node is not visited (new province)
        		count++;
        	}
        	// Apply BFS traversal
        	while(!q.isEmpty())
        	{
        		int curr = q.poll();

        		for(Integer node: adj.get(curr))
        		{
        			if(!vis[node])
        			{
        				vis[node]=true;
        				q.offer(node);
        			}
        		}
        	}
        }
        return count;
    }
}