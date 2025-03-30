import java.util.*;
class lc515  // Find Largest Value in Each Tree Row
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
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root==null)
            return ans;
        
        // Use queue for storing the nodes at each level
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
        	int size = q.size();
        	int maxVal = Integer.MIN_VALUE;

        	// Traverse the current level of the tree
        	for(int i=0; i<size; i++)
        	{
        		TreeNode curr = q.poll();
                   
                // Find max of all the values in the current level
        		maxVal = Math.max(maxVal, curr.val);

        		if(curr.left!=null)
        			q.offer(curr.left);
        		if(curr.right!=null)
        			q.offer(curr.right);
        	}

        	ans.add(maxVal);
        }

        return ans;
    }
}