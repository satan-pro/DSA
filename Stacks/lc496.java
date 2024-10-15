import java.util.*;
class lc496  // Next Greater Element
{
	 public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=nums2.length-1; i>=0; i--)
        {
        	while(!st.isEmpty() && st.peek()<nums2[i])
        	{	
        		st.pop();
        	}
        	if(!st.isEmpty())
        		map.put(nums2[i], st.peek());
        	else 
        		map.put(nums2[i], -1);
        	st.push(nums2[i]);
        }

        int res[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++)
        {
        	res[i] = map.get(nums1[i]);
        }
        return res;
    }
}