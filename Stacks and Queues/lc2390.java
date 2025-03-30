import java.util.*;
class lc2390
{
	// General StringBuilder approach
	// using deleteCharAt() method from StringBuilder class
	public String removeStars(String s) {
		StringBuilder res = new StringBuilder();

		for(int i=0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			if(ch=='*')
				res.deleteCharAt(res.length()-1);
			else 
				res.append(ch);
		}

		return res.toString();
	}

	// Stack solution
	public String removeStars1(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
        	char ch = s.charAt(i);
        	if(ch=='*')
        		st.pop();
        	else 
        		st.push(ch);
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty())
        	res.append(""+st.pop());

        res.reverse();
        return res.toString();
    }
}