import java.util.*;
class lc735  // Asteroid Collision
{
	boolean areOpposites(int a, int b) {
		if((a>>31)!=(b>>31))
			return true;
		return false;
	}
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=asteroids.length-1; i>=0; i--)
        {
        	int curr=asteroids[i];
        	boolean equal=false;
        	while(!st.isEmpty() && areOpposites(curr, st.peek()))
        	{
        		int top = st.pop();
        		if(Math.abs(top)>Math.abs(curr))
        			curr=top;
        		else if(Math.abs(top)==Math.abs(curr))
        			equal=true;
        	}
        	if(!equal)
        		st.push(curr);
        }

        int res[] = new int[st.size()];
        int i=0;
        while(!st.isEmpty())
        {
        	res[i]=st.pop();
        	i++;
        }
        return res;
    }
}