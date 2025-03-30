import java.util.*;
class gfgInfixToPostfix
{
	// Steps : 1) If empty stack -> push
	// 2) If '(' push 
	// 3) If ')' pop and add to ans until you find '('
	// 4) If priority(curr) > priority(st.top()) -> push to stack
	// 5) If priority(curr) < priority(st.top()) -> pop and add to ans
	// 6) If operand -> add to ans
	// 7) Add the remaining elements in the stack to ans
	public static String infixToPostfix(String s) {
        // Your code here
        Stack<Character> st = new Stack<>();

        // Create a priority map
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('^', 3);
        priority.put('(', 0);
        priority.put(')', 0);

        // create a set for faster access
        Set<Character> operators = new HashSet<>();
        char arr[] = {'+','-','*','/','^','(',')'};

        for(char c: arr)
        	operators.add(c);

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++)
        {
        	char ch = s.charAt(i);

        	// If the character found is an operator
        	if(operators.contains(ch))
        	{
        		if(st.isEmpty())
        			st.push(ch);
        		else if(ch=='(')
        			st.push(ch);
        		else if(ch==')')
        		{	
        			// Pop all characters until the opening bracket '(' is found 
        			while(!st.isEmpty() && st.peek()!='(')
        			{
        				ans.append(st.pop());
        			}
        			// Pop the opening bracket '(' from the stack
        			if(!st.isEmpty() && st.peek()=='(')
        				st.pop();
        		}
        		else 
        		{
        			// if priority of stack top is lower, pop from stack
        			while(!st.isEmpty() && priority.get(ch)<=priority.get(st.peek()))
        				ans.append(st.pop());

        			// insert into the stack if the priority is greater than stack top
        			st.push(ch);
        		}
        	}
        	// add the operands to the answer
        	else if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9'))
        		ans.append(ch);
        }

        // add the remaining elements in the stack
        while(!st.isEmpty())
        	ans.append(st.pop());

        return ans.toString();
    }
}