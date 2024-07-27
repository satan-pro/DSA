import java.util.*;
class lc121
{
	public int maxProfit(int[] prices) {
        
        int i=0,j=0,small=prices[i],max=prices[j];
        int diff = max-small;
        for(; j<prices.length; j++)
        {
        	if(prices[j]-prices[i]>diff)
        		diff=prices[j]-prices[i];

        	if(prices[j]<prices[i])
        		i=j;
        }
        return diff;
    }
    public static void main(String[] args) {
    	int a[] = {7,1,5,3,6,4};

    	lc121 obj = new lc121();
    	int res = obj.maxProfit(a);
    	System.out.println(res);
    }
}