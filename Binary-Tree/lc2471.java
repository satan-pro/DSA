import java.util.*;
class lc2471
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
    // function to find the index of the number passed as an argument
    public int findIndex(int[] arr, int x) {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==x)
                return i;
        }
        return -1;
    }
    // function to swap elements of an array
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // function to find the no of swaps needed to sort the unsorted array
    public int findOps(int[] arr) {
        int ans = 0;
        int tempArr[] = Arrays.copyOf(arr, arr.length);

        Arrays.sort(tempArr);

        for(int i=0; i<tempArr.length; i++)
        {
            if(arr[i]!=tempArr[i])
            {
                ans++;
                swap(arr, i, findIndex(arr, tempArr[i]));
            }
        }
        return ans;
    }
	public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int count = 0;

        while(!q.isEmpty())
        {
        	int size = q.size();

        	for(int i=0; i<size; i++)
        	{
                // Remove each node from the current queue and insert its left and right nodes in the queue
        		TreeNode curr = q.poll();

        		if(curr.left!=null)
        			q.offer(curr.left);
        		if(curr.right!=null)
        			q.offer(curr.right);
        	}

            // Create an array to store the nodes in the current version of the queue
            int currNodes[] = new int[q.size()];
            int k=0;

            for(TreeNode node: q)
                currNodes[k++] = node.val;

            // Perform the following operations on the array:
            // 1. Sort the array
            // 2. Count the no of swaps required to sort the unsorted array
            // 3. Create an additional findIndex function to dfind the index of the current element
            count+=findOps(currNodes);
        }

        return count;
    }
}