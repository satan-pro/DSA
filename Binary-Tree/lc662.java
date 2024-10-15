import java.util.*;
class lc662
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

  	// Intuition : Level order traversal of Binary Tree
  	// Create a Tuple with treenode and number of the node
  	// While adding the nodes in the queue, the node number will be :
  	// For left-child : 2*currNode+1, For right-child : 2*currNode+2
	class Tuple
	{
		TreeNode node;
		int col;
		public Tuple(TreeNode root, int a)
		{
			node=root;
			col=a;
		}
	}
	public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0));
        int maxWidth=Integer.MIN_VALUE;

        while(!q.isEmpty())
        {
        	int size = q.size();
        	int currWidth=0;
        	for(int i=0; i<size; i++)
        	{
	        	Tuple t = q.poll();
	        	TreeNode curr = t.node;
	        	int currCol = t.col;

	        	if(i==0)
	        		currWidth-=currCol;
	        	if(i==size-1)
	        		currWidth+=currCol;

	        	if(curr.left!=null)
	        		q.offer(new Tuple(curr.left, 2*currCol+1));
	        	if(curr.right!=null)
	        		q.offer(new Tuple(curr.right, 2*currCol+2));
	        }
	        maxWidth = Math.max(maxWidth, currWidth+1);
        }
        return maxWidth;
    }
}