import java.util.*;
class lc101
{
	// boolean isLeaf(TreeNode root)
	// {
	// 	if(root.left==null && root.right==null)
	// 		return true;
	// 	return false;
	// }
	// void inorder(TreeNode root, List<Integer> res)
	// {
	// 	if(root!=null)
	// 	{
	// 		inorder(root.left, res);
	// 		res.add(root.val);
	// 		inorder(root.right, res);
	// 	}
	// 	else if(!isLeaf(root))
	// 	{
	// 		res.add(-200);
	// 	}
	// }
	// public boolean isSymmetric(TreeNode root) {
	// 	if(root==null)
	// 		return true;

    //     List<Integer> l1 = new ArrayList<>();
    //     List<Integer> l2 = new ArrayList<>();

    //     inorder(root.left, l1);
    //     Collections.reverse(l1);
    //     inorder(root.right, l2);

    //     if(l1.size()!=l2.size())
    //     	return false;
    //     for(int i=0; i<l1.size(); i++)
    //     {
    //     	if(l1.get(i)!=l2.get(i))
    //     		return false;
    //     }
    //     return true;
    // }

	public boolean findSymm(TreeNode root1, TreeNode root2)
	{
		if(root1==null && root2==null)
			return true;
		if((root1==null && root2!=null) || (root1!=null && root2==null))
			return false;
		if((root1.val==root2.val) && findSymm(root1.left, root2.right) && findSymm(root1.right, root2.left))
			return true;
		return false;
	}
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        	return true;
        return findSymm(root.left, root.right);
    }
}