import java.util.*;
class gfgBoundaryTraversal
{
	class Node  
 { 
     int data; 
     Node left, right; 
   
     public Node(int d)  
     { 
         data = d; 
         left = right = null; 
     } 
 }
	boolean isLeaf(Node root)
	{
		if(root.left==null && root.right==null)
			return true;
		return false;
	}
	void leftBoundary(Node root, ArrayList<Integer> ans)
	{
		if(root!=null)
		{
			if(!isLeaf(root))
				ans.add(root.data);
			if(root.left!=null)
				leftBoundary(root.left, ans);
			else 
				leftBoundary(root.right, ans);
		}
	}
	void leafNodes(Node root, ArrayList<Integer> ans)
	{
		if(root!=null)
		{
			if(isLeaf(root))
				ans.add(root.data);
			leafNodes(root.left, ans);
			leafNodes(root.right, ans);
		}
	}
	void rightBoundary(Node root, ArrayList<Integer> ans)
	{
		Stack<Integer> st = new Stack<>();
		while(root!=null)
		{
			if(!isLeaf(root))
				st.push(root.data);
			if(root.right!=null)
				root=root.right;
			else 
				root=root.left;
		}

		while(!st.isEmpty())
			ans.add(st.pop());
	}
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(node==null)
	    	return ans;

	    if(!isLeaf(node))
	    	ans.add(node.data);

	    leftBoundary(node.left, ans);
	    leafNodes(node, ans);
	    rightBoundary(node.right, ans);

	    return ans;
	}
}