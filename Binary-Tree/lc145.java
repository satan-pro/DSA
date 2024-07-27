import java.util.*;
class lc145 // Iterative PostOrder Traversal of Binary Tree
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

  	// Using 2 Stacks Method
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
        	return ans;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(s1.size()!=0)
        {
        	TreeNode curr = s1.pop();
        	if(curr.left!=null)
        		s1.push(curr.left);
        	if(curr.right!=null)
        		s1.push(curr.right);
        	s2.push(curr);
        }
        while(s2.size()>0)
        {
        	ans.add(s2.pop().val);
        }
        return ans;
    }
}