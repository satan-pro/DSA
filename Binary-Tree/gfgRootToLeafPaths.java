import java.util.*;
class gfgRootToLeafPaths
{
	class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
	public static boolean isLeaf(Node root)
	{
		if(root.left==null && root.right==null)
			return true;
		return false;
	}
	public static void traverse(ArrayList<ArrayList<Integer>> path, ArrayList<Integer> temp, Node root)
	{
		if(root!=null)
		{
			temp.add(root.data);
			if(isLeaf(root))
			{
				path.add(new ArrayList<>(temp));
				temp.remove(temp.get(temp.size()-1));
				return;
			}
			traverse(path, temp, root.left);
			traverse(path, temp, root.right);
		}
	}
	public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
		ArrayList<ArrayList<Integer>> path = new ArrayList<>();
		traverse(path, new ArrayList<>(), root);
		return path;
    }
}