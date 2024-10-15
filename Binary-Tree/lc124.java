import java.util.*;
class lc124
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

  	// Intuition : This problem is similar to lc543:Diameter of Binary Tree
  	// Check the maxSum for each node which is the sum of left and right subtree
  	// For each node return only the max of the left and right subtree (Reason : A node is visited only once in a path so it is either the left subtree or the right subtree)
  	// So for each node return only node.val + max(left, right)
  	// Do not include negative values as it brings down the maximum sum (Kadane's Algorithm)
	int maxSum = Integer.MIN_VALUE;
	int findSum(TreeNode root)
	{
		if(root==null)
        	return 0;
        int left = Math.max(0,findSum(root.left));
        int right = Math.max(0, findSum(root.right));
        maxSum = Math.max(maxSum, left+right+root.val);
        return root.val+Math.max(left, right);
	}
	public int maxPathSum(TreeNode root) {
        findSum(root);
        return maxSum;
    }
}