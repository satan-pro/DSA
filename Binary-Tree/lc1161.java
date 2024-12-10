import java.util.*;
class lc1161
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
	public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
        	if(a[1]==b[1])
        		return a[0]-b[0];
        	return b[1]-a[1];
        });

        q.offer(root);

        int level = 1;
        while(!q.isEmpty())
        {
        	int qsize = q.size();

        	int sum=0;
        	for(int i=0; i<qsize; i++)
        	{
        		TreeNode curr = q.poll();
        		sum+=curr.val;

        		if(curr.left!=null)
        			q.offer(curr.left);
        		if(curr.right!=null)
        			q.offer(curr.right);
        	}
        	pq.offer(new int[]{level, sum});
        	level++;
        }

        int[] resArr = pq.poll();

        return resArr[0];
    }
}