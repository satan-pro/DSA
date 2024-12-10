import java.util.*;
class lc2097
{
    // Recursive DFS for Eulerian Path
    public void dfs(int node, ArrayList<Integer> path, HashMap<Integer, ArrayList<Integer>> map) {
        // Checking if the node contains edges and is a valid node with outgoing edges
        while(map.containsKey(node) && !map.get(node).isEmpty())
        {
            // Take the list of edges from the node and remove the first element from it and assign it to nextNode
            int nextNode = map.get(node).remove(0);
            // Perform dfs of all the edges before processing the next node
            dfs(nextNode, path, map);
        }
        // Here the node is added to the front of the list, because recursion works in reverse order so it is important that the order of the Eulerian path is maintained
        path.add(0, node);
    }

    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> degree = new HashMap<>();

        // Create the graph 
        for(int arr[]: pairs)
        {
            map.putIfAbsent(arr[0], new ArrayList<>());
            map.get(arr[0]).add(arr[1]);

            // Keep a track of the degree of the graph ; degree = indegree - outdegree
            degree.put(arr[0], degree.getOrDefault(arr[0], 0)-1);
            degree.put(arr[1], degree.getOrDefault(arr[1], 0)+1);
        }

        int startNode = pairs[0][0];
        for(Map.Entry<Integer, Integer> elem: degree.entrySet())
        {
            // Start with the node whose degree is -1 (condition for euler circuit)
            if(elem.getValue()==-1)
            {
                startNode = elem.getKey();
                break;
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        dfs(startNode, path, map);

        // Create the final result array
        int res[][] = new int[pairs.length][2];
        int k=0;
        for(int i=0; i<path.size()-1; i++)
        {
            res[k][0] = path.get(i);
            res[k][1] = path.get(i+1);
            k++;
        }
        return res;
    }
}