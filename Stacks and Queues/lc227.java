import java.util.*;
class lc227  // Basic Calculator II
{	
	public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;	
        char opr = '+';

        Set<Character> operators = new HashSet<>();
        char arr[] = {'+','-','*','/'};

        for(char c: arr)
        	operators.add(c);

        for(int i=0; i<s.length(); i++)
        {
        	char ch = s.charAt(i);

        	if(Character.isDigit(ch))
        	{
        		num = num*10+(int)(ch-'0');
        	}

        	// Important condition: is it is the last character of string -> execute this block
        	if(operators.contains(ch) || i==s.length()-1)
        	{
        		// Important: Here we are always applying the previous operator and storing the current operator in a variable for next use
        		
        		// Push into stack if it is '+' or '-'
        		if(opr=='+')
        			st.push(num);
        		if(opr=='-')
        			// For '-' push -num
        			st.push(-num);

        		// Apply operator on st.pop() and then push if it is '*' or '/'
        		if(opr=='*')
        			st.push(st.pop()*num);
        		if(opr=='/')
        			st.push(st.pop()/num);

        		num = 0;

        		// Change the current operator
        		opr = ch;
        	}
        }

        int res = 0;

        // The remaining values in the stack have only '+' or '-' operations
        // '-' has been handled by -num
        // Hence add all the remaining values in the stack 
        while(!st.isEmpty())
        	res+=st.pop();

        return res;
    }
}