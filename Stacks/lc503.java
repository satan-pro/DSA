import java.util.*;
class lc503  // Next Greater Element II
{
	public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> notFound = new ArrayList<>();
        int res[] = new int[nums.length];

        for(int i=nums.length; i>=0; i--)
        {
        	while(!st.isEmpty() && st.peek()<nums[i])
        	{
        		st.pop();
        	}
        	if(!st.isEmpty())
        		res[i]=st.peek();
        	else 
        	{
        		res[i]=-1;
        		notFound.add(i);
        	}
        	st.push(nums[i]);
        }

        for(int i:notFound)
        {
        	while(!st.isEmpty() && st.peek()<nums[i])
        	{
        		st.pop();
        	}
        	if(!st.isEmpty())
        		res[i]=st.peek();
        }

        return res;
    }
}