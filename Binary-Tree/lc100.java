import java.util.*;
class lc100  // Same Tree
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
	boolean check=true;
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if((p==null && q!=null) || (q==null && p!=null))
            return false;
        if(p!=null && q!=null)
        {
        	if(p.val!=q.val)
        		return false;
        	check = check && isSameTree(p.left, q.left);
        	check = check && isSameTree(p.right, q.right);
        }
        return check;
    }
}