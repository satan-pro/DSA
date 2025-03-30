import java.util.*;
class lc2381  // Shifting Letters II
{
	// Brute Force Solution 
	// TC : O(n x m)
	public String shiftingLetters1(String s, int[][] shifts) {
        int[] prefix = new int[s.length()];

        // Building the prefix array by repeatedly traversing the shifts array
        for(int i=0; i<shifts.length; i++)
        {
        	int start = shifts[i][0];
        	int end = shifts[i][1];
        	int dir = shifts[i][2]==0?-1:1;

        	for(int j=start; j<=end; j++)
        	{
        		prefix[j]+=dir;
        	}
        }

        StringBuilder st = new StringBuilder();

        // Appending the final characters to the result
        for(int i=0; i<s.length(); i++)
        {
        	int c = ((int)s.charAt(i) - 'a' + prefix[i])%26;
        	if(c<0)
        		c+=26;
        	c+='a';

        	st.append((char)c);
        }

        return st.toString();
    }

    // Prefix Sum Approach
    // TC : O(n + m)
    public String shiftingLetters(String s, int[][] shifts) {
    	int[] prefix = new int[s.length()];

    	// Build the prefix array by incrementing the prefix[start] and decrementing the prefix[end+1]
    	for(int i=0; i<shifts.length; i++)
    	{
    		int start = shifts[i][0];
        	int end = shifts[i][1];
        	int dir = shifts[i][2]==0?-1:1;

        	prefix[start]+=dir;
        	if(end+1<s.length())
        		prefix[end+1]-=dir;
    	}

    	// Now add the previous prefix val to the currrent val, which makes the prefix array a cumulative sum of the shifts
    	for(int i=1; i<prefix.length; i++)
    	{
    		prefix[i]+=prefix[i-1];
    	}

    	StringBuilder st = new StringBuilder();

        // Build the resulting string
        for(int i=0; i<s.length(); i++)
        {
        	int c = ((int)s.charAt(i) - 'a' + prefix[i])%26;
        	if(c<0)
        		c+=26;
        	c+='a';

        	st.append((char)c);
        }

        return st.toString();
    }
}