import java.util.*;
class lc2583  // Kth Largest Sum in a Binary Tree
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

  	// Intuition: Find the total sum of the nodes at each level by storing the level nodes in a queue
  	// For each level calculate the total sum and store it inside a PriorityQueue sorted in descending order
  	// if k > pq.size() return -1
  	// Find the kth element in the pq and return the ans
	public long kthLargestLevelSum(TreeNode root, int k) {
		if(root==null)
			return -1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->Long.compare(b,a));

        while(!q.isEmpty())
        {
        	int qsize = q.size();
        	long sum=0;

        	for(int i=0; i<qsize; i++)
        	{
        		TreeNode curr = q.poll();
        		sum+=curr.val;

        		if(curr.left!=null)
        			q.offer(curr.left);
        		if(curr.right!=null)
        			q.offer(curr.right);
        	}
        	pq.offer(sum);
        }

       if(k>pq.size())
       	return -1;
       long res=0;
       while(k>0)
       {
       		res = pq.poll();
       		k--;
       }
       return res;
    }
}