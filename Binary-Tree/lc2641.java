import java.util.*;
class lc2641
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
	class Pair
	{
		TreeNode parent;
		TreeNode node;
		public Pair(TreeNode r, TreeNode c) {
			parent = r;
			node = c;
		}
	}
	class Tuple
	{
		TreeNode node;
		int level;
		int sum;
		public Tuple(TreeNode t, int l, int s) {
			node = t;
			level = l;
			sum = s;
		}
	}
	public TreeNode replaceValueInTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        Queue<Tuple> q2 = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        q.offer(new Pair(null, root));
        int level=0;

        while(!q.isEmpty())
        {
        	int qsize = q.size();
        	int sum=0;
        	int totSum=0;
        	Pair prev = null;

        	for(int i=0; i<qsize; i++)
        	{
        		Pair curr = q.poll();

        		if(prev==null || prev.parent==curr.parent)
        			sum+=curr.node.val;
        		else 
        		{
        			q2.offer(new Tuple(prev.parent, level, sum));
        			sum = curr.node.val;
        		}
        		if(i==qsize-1)
        			q2.offer(new Tuple(curr.parent, level, sum));

        		totSum+=curr.node.val;

        		if(curr.node.left!=null)
        			q.offer(new Pair(curr.node, curr.node.left));
        		if(curr.node.right!=null)
        			q.offer(new Pair(curr.node, curr.node.right));

        		prev=curr;
        	}
        	map.put(level, totSum);
        	level++;
        }

        while(!q2.isEmpty())
        {
        	Tuple t = q2.poll();

        	if(t.level==0)
        		root.val = 0;
        	else 
        	{
        		int levelSum = map.get(t.level);
        		int childSum = levelSum - t.sum;

        		if(t.node.left!=null)
        			t.node.left.val = childSum;
        		if(t.node.right!=null)
        			t.node.right.val = childSum;
        	}
        }

        return root;

    }
}