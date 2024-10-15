import java.util.*;
class lc863
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
	// Find the kth Node from the given distance
	public void findKthNode(TreeNode node, int k, int dist, List<Integer> res) {
		if(node==null)
			return;
		if(dist==k)
			res.add(node.val);
		findKthNode(node.left, k, dist+1, res);
		findKthNode(node.right, k, dist+1, res);
	}

	// Find the target node, check if it is lef or subtree and find the nodes in the other subtree
	public int findTargetNode(TreeNode root, TreeNode target, int k, List<Integer> ans) {
		// Return -1 if null value
		if(root==null)
			return -1;
		if(root==target)
		{
			// If target node is found, then find the kth children of target node
			findKthNode(target, k, 0, ans);
			return 0;
		}

		// NOTE (V.V.IMP) : We are checking the target node from each node and not only from the tree's root
		// This is handling the edge case when target node is a leaf node 
		// Another edge case when the target branchs out from a subtree of the tree's root

		// Find the target node in the left subtree
		int left = findTargetNode(root.left, target, k, ans);

		// Check if target is found in the left subtree
		if(left!=-1)
		{
			if(left+1==k)
				// If the root is at kth distance add it to ans
				ans.add(root.val);
			else
				// Find the kth nodes from the right subtree 
				findKthNode(root.right, k-left-2, 0, ans);
			// Return the distance from the target to the current node
			return left+1;
		}

		// Find the target node in the right subtree
		int right = findTargetNode(root.right, target, k, ans);

		// Check if the node is present in the right subtree
		if(right!=-1)
		{
			if(right+1==k)
				// If the current node is at kth distance add it to ans
				ans.add(root.val);
			else 
				// Find the kth node in the left subtree
				findKthNode(root.left, k-right-2, 0, ans);
			// Return the distance from the target to the current node
			return right+1;
		}
		// Return -1 if the target node is not found in the tree
		return -1;
	}
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> ans = new ArrayList<>();

		// Call only this func as it handles both conditions:
		// Finding kth nodes from subtree of target node
		// Finding kth nodes from above target/ subtree in which target doesnt appear
		findTargetNode(root, target, k, ans);
		return ans;
	}

	class Pair {
		TreeNode root;
		int dist;

		public Pair(TreeNode node, int k) {
			root=node;
			dist=k;
		}
	}
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q1 = new LinkedList<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();

        q1.offer(root);

        while(!q1.isEmpty())
        {
        	TreeNode curr = q1.poll();
        	vis.put(curr.val, false);

        	if(curr.left!=null)
        	{
        		q1.offer(curr.left);
        		map.put(curr.left.val, curr);
        	}
        	if(curr.right!=null)
        	{
        		map.put(curr.right.val, curr);
        		q1.offer(curr.right);
        	}
        }

        Queue<Pair> q2 = new LinkedList<>();
        q2.offer(new Pair(target, 0));

        List<Integer> ans = new ArrayList<>();

        while(!q2.isEmpty())
        {
        	int qSize = q2.size();

        	for(int i=0; i<qSize; i++)
        	{
        		Pair p = q2.poll();
        		TreeNode curr = p.root;
        		int currDist = p.dist;

        		vis.put(curr.val, true);

        		if(currDist==k)
        			ans.add(curr.val);

        		if(map.containsKey(curr.val))
        		{
        			TreeNode currParent = map.get(curr.val);
        			if(!vis.get(currParent.val))
        				q2.offer(new Pair(currParent, currDist+1));
        		}

        		if(!vis.get(curr.left.val))
        			q2.offer(new Pair(curr.left, currDist+1));

        		if(!vis.get(curr.right.val))
        			q2.offer(new Pair(curr.right, currDist+1));
        	}
        }
        return ans;
    }
}