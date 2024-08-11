import java.util.*;
class lc104  // Height of a Binary Tree
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
	public int maxDepth(TreeNode root) {
        if(root!=null)
        {
        	int left = maxDepth(root.left);
        	int right = maxDepth(root.right);
            return 1+Math.max(left, right);
        }
        return 0;
    }
}