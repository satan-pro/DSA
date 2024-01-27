import java.util.*;
public class lc150
{
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> operand = new Stack<>();
        //Stack<String> operator = new Stack<>();

        for(String token: tokens)
        {
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/"))
            {
                int i = Integer.parseInt(token);
                operand.push(i);
            }
            else{
                int op1 = operand.pop();
                int op2 = operand.pop();
                if(token.equals("+"))
                {
                    operand.push(op1+op2);
                }
                else if(token.equals("-"))
                {
                    operand.push(op1-op2);
                }
                else if(token.equals("*"))
                {
                    operand.push(op1*op2);
                }
                else if(token.equals("/"))
                {
                    operand.push(op1/op2);
                }
            }
            System.out.println(operand);
        }
        int res = operand.pop();
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> al = new ArrayList<String>();
        String st="";
        while(!st.equals("-1"))
        {
            st=sc.next();
            al.add(st);
        }

        String inp[] = new String[al.size()];
        inp = al.toArray(inp);

        lc150 obj = new lc150();

        int res = obj.evalRPN(inp);
        System.out.println(res);
    }
}