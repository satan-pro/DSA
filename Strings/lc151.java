import java.util.*;
class lc151
{
	public String reverseWords(String s) {
        s=s.trim();
        String res="";

        int i=0, j=i, k=0;
        for(; i<s.length(); i++)
        {
        	if(s.charAt(i)!=' ' && j<k)
        		j=i;

        	if(s.charAt(i)==' ' && j>=k)
        	{
        		res=s.substring(j,i)+" "+res;
        		k=i;
        		if(((i+1)<s.length()) && s.charAt(i+1)!=' ')
        			j=i+1;
        	}
        }
        res=s.substring(j)+" "+res;
        return res.trim();
    }
}