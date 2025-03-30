import java.util.*;
class gfgPrefixToInfix
{
	static String preToInfix(String s) {
        // code here
        Stack<String> st = new Stack<>();

        char arr[] = {'+','-','*','/','^'};
        Set<Character> operators = new HashSet<>();

       	for(char c: arr)
       		operators.add(c);

       	for(int i=s.length()-1; i>=0; i--)
       	{
       		char ch = s.charAt(i);

       		if(operators.contains(ch))
       		{
       			if(st.size()>=2)
       			{
       				String op1 = st.pop();
       				String op2 = st.pop();

       				st.push("("+op1+ch+op2+")");
       			}
       		}
       		else 
       			st.push(""+ch);
       	}

       	return st.pop();
    }
}