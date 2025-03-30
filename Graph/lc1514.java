import java.util.*;
class lc1514  // Path with Maximum Probability
{
	public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();

        for(int i=0; i<n; i++)
        	adj.add(new ArrayList<>());

        // Build the undirected graph adjacency list
        for(int i=0; i<edges.length; i++)
        {
        	adj.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
        	adj.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }	

        // Result array to store probabilities for all nodes
        double probs[] = new double[n];
        Arrays.fill(probs, Double.MIN_VALUE);

        // Max-heap Priority Queue
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[1], a[1]));
        pq.offer(new double[]{(double)start_node, 1.0});
        probs[start_node] = 1.0;

        // Classic Djikstra Algorithm
        while(!pq.isEmpty())
        {
        	double pair[] = pq.poll();
        	int currNode = (int)pair[0];
        	double currProb = pair[1];

        	// if the end_node is found return the answer(as it will be always max because of the Max-Heap used)
        	if(currNode == end_node)
        		return currProb;

        	for(double[] next: adj.get(currNode))
        	{
        		int nextNode = (int)next[0];
        		double nextProb = next[1];

        		if(currProb * nextProb > probs[nextNode])
        		{
        			probs[nextNode] = currProb * nextProb;
        			pq.offer(new double[]{(double)nextNode, probs[nextNode]});
        		}
        	}
        }

        return 0.0;
    }
}