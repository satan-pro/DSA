import java.util.*;
class lc29
{
	public int divide(int dividend, int divisor) {
        if(dividend==divisor)
        	return 1;
        if(dividend==Integer.MIN_VALUE && divisor==-1)
        	return Integer.MAX_VALUE;

        boolean sign = true;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0))
        	sign = false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res=0;

        while(dividend>=divisor)
        {
        	int count=0;
        	while(dividend>=(divisor<<(count+1)))
        		count++;
        	res+=(1<<count);
        	dividend-=(divisor<<count);
        }

        res = sign?res:-res;

        return Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, res));
    }
}