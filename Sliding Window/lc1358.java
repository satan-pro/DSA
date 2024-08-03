import java.util.*;
class lc1358 // Number of Substrings containing All Three Characters (IMPORTANT)
{
	public int numberOfSubstrings(String s) {
        int i=0, j=0;
		int a, b, c, count;
		a=b=c=-1; // Initialize the most recent psoitions of a,b anc c
		count=0;
		while(j<s.length()) // Sliding Window 
		{
			// Update positions when character is encountered
			if(s.charAt(j)=='a') 
				a=j;
			else if(s.charAt(j)=='b')
				b=j;
			else if(s.charAt(j)=='c')
				c=j;

			// For each iteration satisfying this condition, count the no of substrings
			if(a>-1 && b>-1 && c>-1)
			{
				count++; // Take the current minimal substring
				int minInd = Math.min(a, Math.min(b, c)); // Find the minimum index of the window

				// All other characters before the minimal window can be included to the substring
				// So, add all characters before the minimal window
				count+=minInd;
			}
			j++;
		}
		return count;
    }
}

