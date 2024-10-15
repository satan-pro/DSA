import java.util.*;
class lc236
{
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  	// Intuition : Check for the nodes p and q in the left and right subtrees
  	// Return the node if p/q is found or if the node reaches null
  	// Case 1 : if p and q are on left and right subtrees, then return the current node where p/q are returned
  	// Case 2 : if any one of the nodes is inside a subtree of the other node 
  	// For case 2 if any one node is found, it gets returned and the other subtree will return null (it will not find the other node)
  	// So return the node which was found (for case 2)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null | root==p | root==q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left==null)
			return right;
		else if(right==null)
			return left;
		else 
			return root;
    }
}