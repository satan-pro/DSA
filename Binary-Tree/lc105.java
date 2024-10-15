import java.util.*;
class lc105  // Construct Binary Tree from Preorder and Inorder Traversal
{
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

	// Intuition: The first element of a preorder is the root, and left of a root in order is the left subtree and its right is the right subtree
	// Procedure: Hash the inorder array by the indexes
  	// Check the first element of the preorder array and find the corresponding index in the inorder map
  	// The left of the current node will be the left of the index in the inorder array and preorder-index+no-of-nodes-in-left-subtree
  	// Right subtree will be the right of the current inorder index and in the preorder array it will be preorder-index+no-of-nodes-in-left_subtree to end of preorder array
  	// NOTE: If the preorder start exceeds preEnd (same for inorder array) then it is a null node and return null 
	public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
		if(preStart>preEnd || inStart>inEnd)
			return null;

		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = map.get(preorder[preStart]);
		int numsLeft = inIndex-inStart;

		root.left = construct(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inIndex-1, map);

		root.right = construct(preorder, preStart+numsLeft+1, preEnd, inorder, inIndex+1, inEnd, map);

		return root;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    HashMap<Integer, Integer> map = new HashMap<>();

	    for(int i=0; i<inorder.length; i++)
	    {
	    	map.put(inorder[i], i);
	    }

	    TreeNode root = construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
	    return root;
	}
}