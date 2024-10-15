import java.util.*;
class lc2236
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

    // Intuition : Check for all nodes if the sum property is valid or not
    // Base Case : If node is null or a leaf node then return true
    // If one of the left/right nodes is null then assign the missing node's value as 0 and continue checking for the condition
	public boolean checkTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return true;

        int left = root.left==null?0:root.left.val;
        int right = root.right==null?0:root.right.val;

        if(left+right==root.val && checkTree(root.left) && checkTree(root.right))
        	return true;
        return false;
    }
}