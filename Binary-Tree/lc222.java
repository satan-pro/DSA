import java.util.*;
class lc222
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
	public void traverse(TreeNode root, int[] count) {
		if(root.left!=null)
		{
			count[0]++;
			traverse(root.left, count);
		}
		if(root.right!=null)
		{
			count[0]++;
			traverse(root.right, count);
		}
	}
	public int countNodes1(TreeNode root) {
		int count[] = new int[1];
		if(root==null)
			return 0;

		count[0]=1;
        traverse(root, count);

        return count[0];
    }

    public int countNodes(TreeNode root) {
    	if(root==null)
    		return 0;
    	int count=1;
    	int left=countNodes(root.left);
    	int right=countNodes(root.right);
    	return count+left+right;
    }
}