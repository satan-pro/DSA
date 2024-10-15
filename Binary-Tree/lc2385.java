import java.util.*;
class lc2385
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
		TreeNode node;
		int time;
		public Pair(TreeNode root, int t)
		{
			node=root;
			time=t;
		}
	}
	public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q1 = new LinkedList<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();

        q1.offer(root);
        TreeNode startNode=null;

        // Do a level order traversal of the tree and create a parent map
        while(!q1.isEmpty())
        {
        	TreeNode curr = q1.poll();

          // Initialize a visited map
        	vis.put(curr.val, false);

        	if(curr.val==start)
        		startNode=curr;

          // Input the nodes into the queue and the parent map
        	if(curr.left!=null)
        	{
        		q1.offer(curr.left);
        		map.put(curr.left.val, curr);
        	}
        	if(curr.right!=null)
        	{
        		q1.offer(curr.right);
        		map.put(curr.right.val, curr);
        	}
        }

        // BFS Traversal 
        Queue<Pair> q2 = new LinkedList<>();
        q2.offer(new Pair(startNode, 0));
        vis.replace(startNode.val, true);
        int currTime=0;

        while(!q2.isEmpty())
        {
          // Traverse for a particular level of the BFS for each minute
        	int size=q2.size();

        	for(int i=0; i<size; i++)
        	{
        		Pair p = q2.poll();
        		int currVal = p.node.val;
        		currTime = p.time;

            // Traverse to parent of current Node if it is unvisited
        		if(map.containsKey(currVal))
        		{
        			TreeNode parentNode = map.get(currVal);
        			if(!vis.get(parentNode.val))
        			{
        				q2.offer(new Pair(parentNode, currTime+1));
        				vis.replace(parentNode.val, true);
        			}
        		}

            // Traverse to child nodes if they are unvisited
        		if(p.node.left!=null && !vis.get(p.node.left.val))
        		{
        			q2.offer(new Pair(p.node.left, currTime+1));
        			vis.replace(p.node.left.val, true);
        		}
        		if(p.node.right!=null && !vis.get(p.node.right.val))
        		{
        			q2.offer(new Pair(p.node.right, currTime+1));
        			vis.replace(p.node.right.val, true);
        		}
        	}
        }
        return currTime;
    }
}