import java.util.*;
class gfgPostfixToInfix
{
	// Steps: 1) If operator is found, pop last 2 elements from stack and operate them
	// 2) If operand is found, push it into the stack
	// 3) Return the top of the stack
	
	static String postToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();

        char[] arr = {'+','-','*','/','^'};
        // Create a set of operators for faster access
        Set<Character> operators = new HashSet<>();

        for(char c: arr)
        	operators.add(c);

        for(int i=0; i<exp.length(); i++)
        {
        	char ch = exp.charAt(i);

        	if(operators.contains(ch))
        	{
        		// If ch is an operator pick the last two elements from stack and operate them
        		if(st.size()>=2)
        		{
        			String op1 = st.pop();
        			String op2 = st.pop();

        			st.push("("+op2+ch+op1+")");
        		}
        	}
        	else 
        		// If the character is an operand, just push it into the stack
        		st.push(""+ch);
        }

        // Stack will contain only one element at the end, return the top of the stack
        return st.pop();
    }
}