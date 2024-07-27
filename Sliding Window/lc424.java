import java.util.*;
class lc424 // Longest Repeating Character Replacement
{
	public int characterReplacement(String s, int k) {
		int maxCount=0;
        for(char c='A'; c<='Z'; c++) // Check for all alphabets
        {
        	int i=0, j=0, freq=0;
        	while(j<s.length())
        	{
        		if(s.charAt(j)!=c)
        			freq++; // Increase freq only if it is some other character
        		
        		while(freq>k) // Sliding Window
        		{
        			if(s.charAt(i)!=c) // Reduce freq if it is other character
        				freq--;
        			i++; 
        		}
        		maxCount = Math.max(maxCount, j-i+1);
        		j++;
        	}

        }
        return maxCount;
    }
}