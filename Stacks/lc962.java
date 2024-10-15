import java.util.*;
class lc962
{
	 public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ramp = 0;

        for(int i=0; i<nums.length-1; i++)
        {
            if(st.isEmpty() || nums[st.peek()]>nums[i])
                st.push(i);
        }

        for(int i=nums.length-1; i>=0; i--)
        {
            while(!st.isEmpty() && nums[st.peek()]<=nums[i])
                ramp = Math.max(ramp, i-st.pop());
        }

        return ramp;
    }
    public static void main(String[] args) {
    	lc962 obj = new lc962();

    	int res = obj.maxWidthRamp(new int[]{2,2,1});
    	System.out.println(res);
    }
}