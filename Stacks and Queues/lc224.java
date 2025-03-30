import java.util.*;
class lc224  // Basic Calculator
{
	public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int curr = 0;
        int n = 0;
        int sign = 1;

        for(int i=0; i<s.length(); i++)
        {
        	char ch = s.charAt(i);

        	if(Character.isDigit(ch))
        	{
        		n = 10*n+(int)(ch-'0');
        	}
        	else if(ch=='(')
        	{
        		// First push the result then the sign
        		st.push(curr);
        		st.push(sign);

        		// Change the sign and result for calculating inside the parenthesis
        		sign = 1;
        		curr = 0;
        	}
        	else if(ch=='+')
        	{
        		curr += sign*n;
        		n = 0;
        		sign = 1;
        	}
        	else if(ch=='-')
        	{
        		curr += sign*n;
        		n = 0;
        		sign = -1;
        	}
        	else if(ch==')')
        	{
        		curr += sign*n;
        		n = 0;

        		// After computing result inside the parenthesis pop the sign and result, and perform suitable operations on it
        		curr *= st.pop();
        		curr += st.pop();
        	}
        }

        // If the last element is a number then compute the final result and return it
        if(n!=0)
        	return curr+=sign*n;

        return curr;
    }
}