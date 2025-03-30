import java.util.*;
class gfgAlienDictionary  // Alien Dictionary
{
	// Kahn's Algorithm for topo sort
	public String findOrder(String[] dict, int k) {
        // Write your code here
        int indegree[] = new int[k];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<k; i++)
        	adj.add(new ArrayList<>());

        // creating the adjacency is the most IMPORTANT
        for(int i=0; i<dict.length-1; i++)
        {
        	// check the consecutive words in the dict
        	String a = dict[i];
        	String b = dict[i+1];
        	// traverse through the smaller word
        	int len = Math.min(a.length(), b.length());

        	for(int j=0; j<len; j++)
        	{
        		// if any character doesnt match, then we need to put the characters in the graph
        		// just like a dictionary the first occuring character is the preceding one
        		// the character occurin on the second word should be succeding
        		if(a.charAt(j)!=b.charAt(j))
        		{
        			int ch1 = a.charAt(j)-'a';
        			int ch2 = b.charAt(j)-'a';

        			// in the directed graph, add the succeding character to the preceding's adjacency list
        			adj.get(ch1).add(ch2);
        			// increase the indegree of the succeding character
        			indegree[ch2]++;
        			// NOTE : it is IMPORTANT to break here; you compare only the first uncommon character in a dict to sort them; hence it is important to break after adding the character to the list
        			break;
        		}
        	}
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indegree.length; i++)
        	if(indegree[i]==0)
        		q.offer(i);

        StringBuilder res = new StringBuilder();

        // perform topo sort using Kahn's algorithm
        while(!q.isEmpty())
        {
        	int curr = q.poll();
        	// building the word order
        	res.append((char)(curr+'a'));

        	for(int node: adj.get(curr))
        	{
        		indegree[node]--;
        		if(indegree[node]==0)
        			q.offer(node);
        	}
        }

        // if graph is cyclic, return empty string
        if(res.length()<k)
        	return "";

        return res.toString();
    }
}