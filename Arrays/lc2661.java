import java.util.*;
class lc2661  // First Completely Painted Row or Column
{
	public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        HashMap<Integer, int[]> map = new HashMap<>();

        // to keep track of no of elements filled in each row and column
        int rows[] = new int[n];
        int cols[] = new int[m];
        Arrays.fill(rows, m);
        Arrays.fill(cols, n);

        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<m; j++)
        	{
        		// Map the unique elements with their position in the matrix
        		map.put(mat[i][j], new int[]{i, j});
        	}
        }

        int ans = -1;
        for(int i=0; i<arr.length; i++)
        {
        	int[] pos = map.get(arr[i]);
        	rows[pos[0]]--;
        	cols[pos[1]]--;

        	// if all elements of a row/column gets filled, return the current index of arr
        	if(rows[pos[0]]==0 || cols[pos[1]]==0)
        		return i;
        }
        // return -1 if not possible
        return ans;
    }
}