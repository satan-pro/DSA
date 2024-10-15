import java.util.*;
class lc297
{
	public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root=="null")
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder res = new StringBuilder();

        while(!q.isEmpty())
        {
    		TreeNode curr = q.poll();
            if(curr==null)
                res.append("null").append(" ");
            else
            {
        		res.append(curr.val).append(" ");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return res.toString().trim();
    }

    public TreeNode createTree(String[] nodes, int ind) {
        if(nodes[ind].equals("null") || ind>=nodes.length)
            return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[ind]));

        root.left = createTree(nodes, 2*ind+1);
        root.right = createTree(nodes, 2*ind+2);

        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null"))
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        String[] nodes = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);

        for(int i=1; i<nodes.length; i++)
        {
            TreeNode curr = q.poll();
            if(!values[i].equals("null"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                curr.left=left;
                q.offer(left);
            }
            if(!values[++i].equals("null"))\
            {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                curr.right = right;
                q.offer(right);
            }
        }     

        return root; 
    }
}
}