import java.util.*;
class lc951
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
	public boolean isValid(TreeNode root1, TreeNode root2) {
		if(root1==null || root2==null)
		{
			if(root1==null && root2==null)
				return true;
			return false;
		}

		int left1 = root1.left==null?-1:root1.left.val;
		int right1 = root1.right==null?-1:root1.right.val;
		int left2 = root2.left==null?-1:root2.left.val;
		int right2 = root2.right==null?-1:root2.right.val;

		boolean child1, child2;

		if(left1==left2)
			child1 = isValid(root1.left, root2.left);
		else if(left1==right2)
			child1 = isValid(root1.left, root2.right);
		else
			return false;

		if(right1==right2)
			child2 = isValid(root1.right, root2.right);
		else if(right1==left2)
			child2 = isValid(root1.right, root2.left);
		else 
			return false;

		return child1 && child2;
	}
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if(root1==null || root2==null)
		{
			if(root1==null && root2==null)
				return true;
			return false;
		}
        if(root1.val!=root2.val)
        	return false;

        boolean res = isValid(root1, root2);
        return res; 	
    }
}