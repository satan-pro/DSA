import java.util.*;
class lc8
{
	int convertInt(char c)
	{
		int d=0;
		switch(c)
		{
		case '0' : d= 0; break;
		case '1': d= 1; break;
		case '2': d= 2; break;
		case '3' : d= 3; break;
		case '4': d= 4; break;
		case '5': d= 5; break;
		case '6' : d= 6; break;
		case '7': d= 7; break;
		case '8': d= 8; break;
		case '9': d= 9; break;
		}
		return d;
	}

	public int myAtoi(String s) {
        s=s.trim();

        if(s.length()==0)
            return 0;
        
        int sign=1;
        int i=0;
        if(s.charAt(i)=='-')
        {
        	sign=-1;
        	i++;
        }
        else if(s.charAt(i)=='+')
        	i++;
        boolean notFound=true;
        int res = 0;

        outer : for(; i<s.length(); i++)
        {
        	if(s.charAt(i)=='0' && notFound)
        		continue;
        	else if(Character.isDigit(s.charAt(i)))
        	{
        		int digit = convertInt(s.charAt(i));

        		if(res>(Integer.MAX_VALUE-digit)/10)
        			return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;

        		res= res*10+digit;
        		notFound=false;
        	}
        	else if(!Character.isDigit(s.charAt(i)))
        		break outer;
        }

        if(notFound)
            return 0;
       
        return res*sign;
    }

    public static void main(String[] args) {
    	String s = "  -042";
    	lc8 obj = new lc8();
    	int res = obj.myAtoi(s);
    	System.out.println(res);
    }
}