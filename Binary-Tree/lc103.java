import java.util.*;
class lc103 // ZigZag Level Order Traversal in Binary Tree
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

  	// Using Stack and Queue Method 
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
        	return ans;
        Stack<TreeNode> st = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        st.push(root);
        boolean leftToRight=true;
        outer: while(true)
        {
        	int levelNodes = st.size();
        	List<Integer> temp = new ArrayList<>();
        	for(int i=0; i<levelNodes; i++)
        	{
        		TreeNode curr = st.pop();
        		temp.add(curr.val);
        		q.offer(curr);
        	}
            if(temp.size()>0)
        	    ans.add(temp);

        	int qSize = q.size();
        	for(int i=0; i<qSize; i++)
        	{
        		TreeNode curr = q.poll();
        		if(leftToRight)
        		{
        			if(curr.left!=null)
        				st.push(curr.left);
        			if(curr.right!=null)
        				st.push(curr.right);
        		}
        		else 
        		{
        			if(curr.right!=null)
        				st.push(curr.right);
        			if(curr.left!=null)
        				st.push(curr.left);
        		}
        	}
            if(q.size()==0 && st.size()==0)
                break outer;
        	leftToRight=!leftToRight;
        }
        return ans;
    }

    // Using only Queue and storing reverse using ArrayList method (ArrayList.add(0,value))
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
        	return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight=true;
        outer: while(q.size()>0)
        {
        	int levelNodes = q.size();
        	List<Integer> temp = new ArrayList<>();
        	for(int i=0; i<levelNodes; i++)
        	{
        		TreeNode curr = q.poll();
        		if(leftToRight)
        			temp.add(curr.val);
        		else
        			temp.add(0, curr.val);

                if(curr.right!=null)
                    q.offer(curr.right);
        		if(curr.left!=null)
        			q.offer(curr.left);
        	}
        	ans.add(temp);
        	leftToRight=!leftToRight;
        }
        return ans;
    }

}