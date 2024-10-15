import java.util.*;
class lc106
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
	public TreeNode construct(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
		if(postStart>postEnd || inStart>inEnd)
			return null;

		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIndex = map.get(postorder[postEnd]);
		int numsLeft = inIndex-inStart;

		root.left = construct(postorder, postStart, postStart+numsLeft-1, inorder, inStart, inIndex-1, map);

		root.right = construct(postorder, postStart+numsLeft, postEnd-1, inorder, inIndex+1, inEnd, map);

		return root;
	} 
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++)
        {
        	map.put(inorder[i], i);
        }

        TreeNode root = construct(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
    }
}