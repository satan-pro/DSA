import java.util.*;
class gfgCountTotalSetBits
{
	// TC - O(log(n))
	public static int countSetBits(int n){
        // Your code here
        int count=0;
        for(int i=1; i<=n; i++)
        {
        
	        while(i>1)
	        {
	        	if((i&1)==1)
	        		count++;
	        	i = i>>1;
	        }
	        if(i==1)
	        	count++;
    	}
        return count;
    }
}