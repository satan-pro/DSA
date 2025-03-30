import java.util.*;
class lc2559  // Count Vowel Strings in Ranges
{
	// helper function for checking vowels
	public boolean isVowel(char ch) {
		if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
			return true;
		return false;
	}
	public int[] vowelStrings(String[] words, int[][] queries) {
		// prefix array for storing count of words with starting and ending vowels
        int[] prefix = new int[words.length];
        int[] ans = new int[queries.length];

        // Building the prefix array
        for(int i=0; i<words.length; i++)
        {
        	if(i>0)
        		prefix[i] = prefix[i-1];

        	if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1)))
        		prefix[i]++;
        }

        // Running the queries to find the answers
        for(int i=0; i<queries.length; i++)
        {
        	// If initial index is 0 then just take the end of the prefix queries
        	if(queries[i][0]==0)
        		ans[i] = prefix[queries[i][1]];
        	else
        		// If not then subtract the previous prefix from the end prefix
        		ans[i] = prefix[queries[i][1]]-prefix[queries[i][0]-1];
        }

        return ans;
    }
}