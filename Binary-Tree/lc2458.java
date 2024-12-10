import java.util.*;
class lc2458
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
	Map<TreeNode, Integer> heightMap = new HashMap<>();

	 public int findHeight(TreeNode root) {
        if(root==null)
            return 0;
        
        int left = findHeight(root.left);
        int right = findHeight(root.right);

        int height = 1+Math.max(left, right);
        heightMap.put(root, height);
        return height;
    }
    public TreeNode findRoot(TreeNode root, int nodeVal) {
    	if(root==null || root.val==nodeVal)
    		return root;
    	TreeNode left = findRoot(root.left, nodeVal);
    	TreeNode right = findRoot(root.right, nodeVal);

    	if(left!=null)
    		return left;
    	return right;
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];

        for(int i=0; i<queries.length; i++)
        {
            int height = heightMap.getOrDefault(findRoot(root,queries[i]),1);
            ans[i] = height-1;
        }

        return ans;
    }
}