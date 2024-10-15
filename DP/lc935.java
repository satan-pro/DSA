import java.util.*;
class lc935
{	
	// i -> current digit, n->number of digits
	int findCount(int i, int n, int dp[][], HashMap<Integer, ArrayList<Integer>> map)
	{
		if(n==0)  // Base Case when it is the last digit left
			return 1;
		if(dp[i][n]!=-1)
			return dp[i][n];

		int count=0; 
		for(int j : map.get(i))
		{	
			// Count the no of ways possible for each digit at each n
			count = (count+findCount(j, n-1, dp, map))%((int)(Math.pow(10,9)+7));
		}
		return dp[i][n]=count;
	}
	public int knightDialer(int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int adj[][] = {{4,6},{6,8},{7,9},{4,8},{3,8,0},{},{1,7,0},{2,6},{1,3},{4,2}};
        for(int i=0; i<=9; i++)
        {
        	ArrayList<Integer> temp = new ArrayList<>();
        	for(int num : adj[i])
        		temp.add(num);
        	map.put(i, temp);
        }

        int dp[][] = new int[10][n];
        for(int[] arr: dp)
        	Arrays.fill(arr, -1);

        int count = 0;

        // Loop through the no of digits to check for each starting digit
        for(int i=0; i<=9; i++)
        {
        	count = (count+findCount(i, n-1, dp, map))%((int)(Math.pow(10,9)+7));
        }
        return count;
    }
}