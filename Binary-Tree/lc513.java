import java.util.*;
class lc513 // Find the Bottom Left Node in Binary Tree
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
	void traverse(TreeNode root, int level, List<Integer> ans)
	{
		if(root==null)
			return;
		if(level==ans.size())
			ans.add(root.val);
		traverse(root.left, level+1, ans);
		traverse(root.right, level+1, ans);
	}
	public int findBottomLeftValue(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, 0, ans);
        return ans.get(ans.size()-1);
    }
}