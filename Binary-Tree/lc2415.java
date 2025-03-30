import java.util.*;
class lc2415
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
	public void traverse(TreeNode root1, TreeNode root2, int level) {
		if(root1==null || root2==null)
			return;

		if(level%2==1)
		{
			int temp = root1.val;
			root1.val = root2.val;
			root2.val = temp;
		}

		traverse(root1.left, root2.right, level+1);
		traverse(root1.right, root2.left, level+1);
	}
	public TreeNode reverseOddLevels(TreeNode root) {
      	traverse(root.left, root.right, 1);

      	return root;
    }

    public TreeNode reverseOddLevels(TreeNode root) {
    	Queue<TreeNode> q = new LinkedList<>();
    	q.offer(root);

    	int level = 1;

    	while(!q.isEmpty())
    	{
    		int size = q.size();

    		List<TreeNode> currentLevel = new ArrayList<>();

    		for(int i=0; i<size; i++)
    		{
    			TreeNode curr = q.poll();

    			if(curr.left!=null)
    				q.offer(curr.left);
    			if(curr.right!=null)
    				q.offer(curr.right);

    			currentLevel.add(curr);
    		}

    		if(level%2==1)
    		{
    			int left=0;
    			int right = currentLevel.size()-1;

    			while(left<right)
    			{
    				int temp = currentLevel.get(left).val;
    				currentLevel.get(left).val = currentLevel.get(right).val;
    				currentLevel.get(right).val = temp;
    				left++;
    				right--;
    			}
    		}
    		level++;
    	}
    	return root;
    }
}