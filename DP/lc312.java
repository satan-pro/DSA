import java.util.*;
class lc312
{
	public int findMax(int i, int j, int[] arr, int dp[][]) {
		if(i>j)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];

		int maxCoins = 0;
		for(int k=i; k<j; k++)
		{
			int coins = arr[i]*arr[k]*arr[j] + findMax(i, k-1, arr, dp) + findMax(k+1, j, arr, dp);
			maxCoins = Math.max(maxCoins, coins);
		}

		return dp[i][j] = maxCoins;
	}
	public int maxCoins(int[] nums) {
		int arr[] = new int[nums.length+2];
		arr[0]=1;
		arr[nums.length+1]=1;
		for(int i=0; i<nums.length; i++)
			arr[i+1] = nums[i];

        int dp[][] = new int[arr.length][arr.length];

        for(int a[]: dp)
        	Arrays.fill(a, -1);

        int res = findMax(1, nums.length-1, arr, dp);
        return res;
    }
}