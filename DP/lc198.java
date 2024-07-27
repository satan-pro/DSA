import java.util.*;
class lc198
{
	// Tabulation Code
	public int rob(int[] nums) {
        
        int dp[] = new int[nums.length];
        dp[0]=nums[0];

        for(int i=1; i<nums.length; i++)
        {
        	int left=nums[i];
        	int right=Integer.MIN_VALUE;

        	if(i>=2)
        		left+=dp[i-2];
        	right=dp[i-1];

        	dp[i] = Math.max(left, right);
        }
        return dp[nums.length-1];
    }

    // Space Optimized Code
    public int rob2(int[] nums) {
        
        int prev=0;
        int prev2=0;

        for(int n : nums)
        {
        	int curr = Math.max(n+prev2, prev);
        	prev2=prev;
        	prev=curr;
        }
        return prev;
    }

    public static void main(String[] args) {
    	int arr[] = {2,1,1,2};
    	lc198 obj = new lc198();
    	int res = obj.rob(arr);
    	System.out.println(res);
    }
}