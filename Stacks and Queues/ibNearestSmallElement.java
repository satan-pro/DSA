import java.util.*;
class ibNearestSmallElement
{
	public int[] prevSmaller(int[] A) {
		int res[] = new int[A.length];
		Stack<Integer> st = new Stack<>();

		for(int i=0; i<A.length; i++)
		{
			while(!st.isEmpty() && st.peek()>=A[i])
				st.pop();
			if(!st.isEmpty())
				res[i]=st.peek();
			else
				res[i]=-1;
			st.push(A[i]);
		}

		return res;
    }
}