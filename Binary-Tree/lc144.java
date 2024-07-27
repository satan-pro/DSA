import java.util.*;
class lc144 // Iterative Preorder Traversal of Binary Tree
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
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
        	return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(st.size()!=0)
        {
        	TreeNode curr = st.pop();
        	if(curr.right!=null)
        		st.push(curr.right);
        	if(curr.left!=null)
        		st.push(curr.left);

        	ans.add(curr.val);
        }
        return ans;
    }
}