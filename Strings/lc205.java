import java.util.*;
class lc205
{
	public boolean isIsomorphic(String s, String t) {
		if(s.length()!=t.length())
			return false;

		// Create arrays to store the characters of both strings (ASCII values)
        int freq1[] = new int[256];
        int freq2[] = new int[256];

        for(int i=0; i<s.length(); i++)
        {
        	char ch1 = s.charAt(i);
        	char ch2 = t.charAt(i);

        	if(freq1[ch1]==0 && freq2[ch2]==0)
            {
            	// Store the corresponding ASCII value in both arrays
        		freq1[ch1] = ch2;
        		freq2[ch2] = ch1;
            }
            // Check if any value doesnt match
        	else if(freq1[ch1]!=ch2 || freq2[ch2]!=ch1)
        		return false;
        }

        return true;
    }
}