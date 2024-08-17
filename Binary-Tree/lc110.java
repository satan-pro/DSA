import java.util.*;
class lc110  // Balanced Binary Tree
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
 	// Brute Force Approach : O(N^2)
 	// Traverse each node of the tree and calculate the height of the left and right subtree of each node
 	// If it does not satisfy the condition return false otherwise return true
 	// If both the left and right subtree are true then only return true
	int findHeight(TreeNode root)
	{
		if(root!=null)
		{
			int left = findHeight(root.left);
			int right = findHeight(root.right);
			return 1+Math.max(left, right);
		}
		return 0;
	}
	 public boolean isBalanced1(TreeNode root) {
	 	if(root==null)
	 		return true;
		if(root!=null)
		{
			int left = findHeight(root.left);
			int right = findHeight(root.right);
			if(Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right))
				return true;
		}
		return false;  
    }

    // Better Approach : O(N)
    // Intuition : Count the height of the left and right subtree by traversing all the way down to the leftmost node and the righmost node respectively
    // If the difference between the leftHeight and rightHeight at any level is greater than 1, return -1;
    // IF the leftHeight or rightHeight calculated by recursion is -1, return -1
    int dfsHeight(TreeNode root)
    {
    	if(root==null)
    		return 0;

    	int lHeight = dfsHeight(root.left);

    	if(lHeight==-1)
    		return -1;

    	int rHeight = dfsHeight(root.right);

    	if(rHeight==-1)
    		return -1;

    	if(Math.abs(lHeight-rHeight)>1)
    		return -1;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    	return 1+Math.max(lHeight, rHeight);
    }
    public boolean isBalanced(TreeNode root) {

    	// If the dfsHeight is -1, it means the tree is unbalanced
    	if(dfsHeight(root)==-1)
    		return false;
    	return true;
    }	
}