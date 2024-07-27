import java.util.*;
class lc94 // Iterative Inorder Traversal of Binary Tree
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
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
        	return ans;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        outer: while(true)
        {
        	if(curr!=null)
        	{
        		st.push(curr);
        		curr=curr.left;
        	}
        	else 
        	{
        		if(st.size()==0)
        			break outer;
        		curr = st.pop();
        		ans.add(curr.val);
        		curr=curr.right;
        	}
        	
        }
        return ans;
    }
}