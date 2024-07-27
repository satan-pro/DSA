import java.util.*;
class gfgLeftViewOfBT // Left View of Binary Tree
{
	class Node
	{
	    int data;
	    Node left, right;

	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	void traverse(Node root, int level, ArrayList<Integer> ans)
    {
        if(root==null)
            return;
        if(level==ans.size())
            ans.add(root.data);
        traverse(root.left, level+1, ans);
        traverse(root.right, level+1, ans);
    }
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ans = new ArrayList<>();
      traverse(root, 0, ans);
      return ans;
    }
}