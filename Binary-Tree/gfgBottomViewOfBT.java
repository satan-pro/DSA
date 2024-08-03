import java.util.*;
class gfgBottomViewOfBT // Bottom View of Binary Tree
{
	class Node
	{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
	    public Node(int key)
	    {
	        data = key;
	        hd = Integer.MAX_VALUE;
	        left = right = null;
	    }
	}
	class Tuple
	{
		Node node;
		int col;
		public Tuple(Node root, int x)
		{
			this.node = root;
			this.col = x;
		}
	}
	 public ArrayList <Integer> bottomView(Node root)
    {
        // Code here

        // Insert each node for a particular column inside the TreeMap and do a level order traversal of the Binary Tree
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0));

        while(!q.isEmpty())
        {
        	Tuple t = q.poll();
        	Node node = t.node;
        	int x = t.col;

        	map.put(x, node.data);

        	if(node.left!=null)
        		q.offer(new Tuple(node.left, x-1));
        	if(node.right!=null)
        		q.offer(new Tuple(node.right, x+1));
        }

        ArrayList<Integer> ans = new ArrayList<>(map.values());
        return ans;
    }
}