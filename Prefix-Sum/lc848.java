import java.util.*;
class lc848  // Shifting Letters
{
	// PrefixSum Approach (Not Optimized)
	// TC: O(2n)
	public String shiftingLetters1(String s, int[] shifts) {
        int[] prefix = new int[s.length()];

        // This is actually a suffix array
        for(int i=shifts.length-1; i>=0; i--)
        {
        	prefix[i]+=shifts[i];

        	// Performing suffix sum, by adding the right elements value to the left one for the shifts
        	// Hence building an array which contains the cumulative shifts for each element
        	if(i<shifts.length-1)
        		prefix[i] = (prefix[i]+prefix[i+1])%26;
        }

        // Building the resulting sring
        StringBuilder st = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
        	int ch = ((int)s.charAt(i) - 'a' + prefix[i])%26;
        	ch+='a';

        	st.append((char)ch);
        }

        return st.toString();
    }

    // Optimized Approach 
    // TC: O(n)
    public String shiftingLetters(String s, int[] shifts) {
    	char st[] = s.toCharArray();
    	int currShift = 0;

    	// Building the string using suffix sum in a single loop
    	for(int i=shifts.length-1; i>=0; i--)
    	{
    		currShift = (currShift + shifts[i])%26;
    		st[i] = (char)((st[i] - 'a' + currShift)%26 + 'a');
    	}

    	return new String(st);
    }
}