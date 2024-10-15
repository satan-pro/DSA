import java.util.*;
class lc114  // Flatten Binary Tree to Linked List
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
	public void traversal(TreeNode root, ArrayList<Integer> arr) {
		if(root!=null)
		{
			arr.add(root.val);
			traversal(root.left, arr);
			traversal(root.right, arr);
		}
	}
	public void flatten(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();

        traversal(root, arr);
        TreeNode prev = root;
        for(int i=1; i<arr.size(); i++)
        {
        	TreeNode node = new TreeNode(arr.get(i));
        	prev.left=null;
        	prev.right=node;
        	prev=node;
        }
    }
}