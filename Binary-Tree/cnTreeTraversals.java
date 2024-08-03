import java.util.*;
class cnTreeTraversals // PreOrder, postOrder and Inorder traversals in one iteration
{
	class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }
	static class Pair
	{
		TreeNode node;
		int num;
		public Pair(TreeNode root, int n)
		{
			this.node = root;
			this.num =n;
		}
	}
	public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        Stack<Pair> st = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null)
        	return ans;

        st.push(new Pair(root, 1));

        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        while(!st.isEmpty())
        {
        	Pair p = st.pop();
        	TreeNode curr = p.node;
        	int n = p.num;

        	if(n==1)  // PreOrder condition
        	{
        		st.push(new Pair(curr, n+1));
        		ans.get(1).add(curr.data);
        		if(curr.left!=null)
        			st.push(new Pair(curr.left, 1));
        	}
        	else if(n==2)  // Inorder Condition
        	{
        		st.push(new Pair(curr, n+1));
        		ans.get(0).add(curr.data);
        		if(curr.right!=null)
        			st.push(new Pair(curr.right, 1));
        	} 
        	else if(n==3)  // PostOrder Condition
        	{
        		ans.get(2).add(curr.data);
        	}
        }
        return ans;
    }
}