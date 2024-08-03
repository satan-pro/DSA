import java.util.*;
class gfgTopViewOfBT // Top View of a Binary Tree
{
	class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
	static class Tuple
	{
		Node node;
		int col;
		public Tuple(Node root, int x)
		{
			this.node=root;
			this.col=x;
		}
	}
	static ArrayList<Integer> topView(Node root) {
        // add your code
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0));

        while(!q.isEmpty())
        {
        	Tuple t = q.poll();
        	Node node = t.node;
        	int x = t.col;

        	// Insert node only if no data exists for the given column
        	if(!map.containsKey(x))
        		map.put(x, node.data);

        	// Do a level order traversal of the Binary Tree using a Queue
        	if(node.left!=null)
        		q.offer(new Tuple(node.left, x-1));
        	if(node.right!=null)
        		q.offer(new Tuple(node.right, x+1));
        }

        ArrayList<Integer> ans = new ArrayList<>(map.values());
        return ans;
    }
}