import java.util.*;
class lc739  // Daily Temperatures
{
	public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();

        int res[] = new int[temperatures.length];
        Arrays.fill(res,0);

        // Perform NGE operations on the array
        for(int i=temperatures.length-1; i>=0; i--)
        {
        	while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i])
        	{
        		st.pop();
        	}
        	if(!st.isEmpty())
        		res[i] = st.peek()-i;
        	st.push(i);
        }

        return res;
    }
}