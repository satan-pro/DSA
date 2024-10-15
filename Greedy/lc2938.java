import java.util.*;
class lc2938
{
	public long minimumSteps(String s) {
        String val[] = s.split("");

        int ones=0;
        long res=0;

        for(int i=0; i<val.length; i++)
        {
        	int curr = Integer.parseInt(val[i]);
        	if(curr==1)
        		ones++;
        	else if(curr==0)
        		res+=ones;
        }
        return res;
    }
}