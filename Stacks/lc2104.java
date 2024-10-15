import java.util.*;
class lc2104
{
	// Brute Force Approach
	public long subArrayRanges1(int[] nums) {
		int n = nums.length;
		int tot=0;
		for(int i=0; i<n-1; i++)
		{
			int min = nums[i];
			int max = nums[i];
			for(int j=1; j<n; j++)
			{
				min = Math.min(min, nums[j]);
				max = Math.max(max, nums[j]);
			}
			tot+=(max-min);
		}
		return tot;
	}

	// Optimal Approach using Monotonic stack
	long subMin(int[] nums, int n, Stack<Integer> st) {
		st.clear();
		int nse[] = new int[n];
        int pse[] = new int[n];

        for(int i=n-1; i>=0; i--)
        {
        	while(!st.isEmpty() && nums[st.peek()]>=nums[i])
        	{
        		st.pop();
        	}
        	nse[i] = st.isEmpty()?-1:st.peek();
        	st.push(i);
        }
        st.clear();
        for(int i=0; i<n; i++)
        {
        	while(!st.isEmpty() && nums[st.peek()]>nums[i])
        	{
        		st.pop();
        	}
        	pse[i] = st.isEmpty()?n:st.peek();
        	st.push(i);
        }

        long res =0;
        for(int i=0; i<n; i++)
        {
        	res+=(long)(i-pse[i])*(nse[i]-i)*nums[i];
        }
        return res;
	}

	long subMax(int[] nums, int n, Stack<Integer> st) {
		st.clear();
		int nge[] = new int[n];
        int pge[] = new int[n];

        for(int i=n-1; i>=0; i--)
        {
        	while(!st.isEmpty() && nums[st.peek()]<=nums[i])
        	{
        		st.pop();
        	}
        	nge[i] = st.isEmpty()?n:st.peek();
        	st.push(i);
        }
        st.clear();
        for(int i=0; i<n; i++)
        {
        	while(!st.isEmpty() && nums[st.peek()]<nums[i])
        	{
        		st.pop();
        	}
        	pge[i] = st.isEmpty()?-1:st.peek();
        	st.push(i);
        }

        long res=0;
        for(int i=0; i<n; i++)
        {
        	res+=(long)(i-pge[i])*(nge[i]-i)*nums[i];
        }
        return res;
	}
	public long subArrayRanges(int[] nums) {
		int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long min = subMin(nums, n, st);
        long max = subMax(nums, n, st);
        return max-min;
    }
}