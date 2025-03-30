import java.util.*;
class lc2379  // Minimum Recolors to get K consecutive Black Blocks
{
	public int minimumRecolors(String blocks, int k) {
        int i=0, j=0;
        int count = Integer.MAX_VALUE;
        int wCount = 0;

        while(j<blocks.length())
        {
        	if(blocks.charAt(j)=='W')
        		wCount++;

        	while(j-i+1>k)
        	{
        		if(blocks.charAt(i)=='W')
        			wCount--;
        		i++;
        	}
 
        	if(j-i+1==k)
        		count = Math.min(count, wCount);

        	j++;
        }

        return count;
    }
}