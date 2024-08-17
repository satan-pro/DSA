import java.util.*;
class lc543  // Diameter of a Binary Tree
{
	class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }
 	// Intuition : Find the max depth at each node of the tree
 	// Create a global variable that stores the maximum path length (lenght of left subtree + length of right subtree) at each node
 	// Update the global variable everytime a greater path is found
 	// Call the findHeight() function only once for the root node; and return the result
	int res=0;
	public int findHeight(TreeNode root)
	{
		if(root==null)
			return 0;
		int left = findHeight(root.left);
		int right = findHeight(root.right);
		res = Math.max(res, left+right);
		return 1+Math.max(left, right);
	}
	public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        	return 0;
        findHeight(root);
        return res;
    }
}