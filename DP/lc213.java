import java.util.*;
class lc213
{
	int maxProf(int ind, int n, int[] nums)
	{
		int prev = nums[ind];
		int prev2 = 0;
		for(int i=ind+1; i<=n; i++)
		{
			int curr = Math.max(nums[i]+prev2, prev);
			prev2 = prev;
			prev=curr;
		}
		return prev;
	}

	public int rob(int[] nums) {
        
        if(nums.length<2)
            return nums[0];
        
        int ans1 = maxProf(0,nums.length-2, nums);
        int ans2 = maxProf(1,nums.length-1, nums);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
    	int arr[] = {1,2,3};
    	lc213 obj = new lc213();
    	int res = obj.rob(arr);
    	System.out.println(res);
    }
}