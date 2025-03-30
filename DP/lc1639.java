import java.util.*;
class lc1639  // Number of Ways to Form a Target String Given a Dictionary
{
	int mod = (int)(1e9 + 7);
	public long findWays(int wordInd, int targetInd, String target, String words[], int[][] charFreq, int[][] dp) {
		// If targetIndex is reached, word has been built
		if(targetInd == target.length())
			return 1;
		// If word characters are finished or if word characters are less than target characters return 0
		if(wordInd==words[0].length() || words[0].length()-wordInd < target.length()-targetInd)
			return 0;
		if(dp[wordInd][targetInd]!=-1)
			return dp[wordInd][targetInd];

		int currChar = target.charAt(targetInd)-'a';

		// Pick the character from the current wordIndex multiplied by the frequency of the currently occuring character in the same wordIndex, and shift the wordIndex and targetIndex by 1
		long pick = ((long)charFreq[wordInd][currChar] * findWays(wordInd+1, targetInd+1, target, words, charFreq, dp))%mod;
		// Do not pick any character from the current wordIndex and shift the wordIndex by 1 , but not the targetIndex
		long notPick = findWays(wordInd+1, targetInd, target, words, charFreq, dp);

		return dp[wordInd][targetInd] = (int)((pick+notPick)%mod);
	}
	public int numWays(String[] words, String target) {
		// Create a dp array consisting of the number of characters in the given words and the no of characters in the traget word
        int dp[][] = new int[words[0].length()][target.length()];

        // create a frequency array to store the frequency of each character at the current index of each given word
        int charFreq[][] = new int[words[0].length()][26];

        for(String word: words)
        {
        	for(int i=0; i<word.length(); i++)
        	{
        		// store the frequency of the character occuring at the current index for each given word
        		char ch = word.charAt(i);
        		charFreq[i][ch-'a']++;
        	}
        }

        for(int[] arr: dp)
        	Arrays.fill(arr, -1);

        int res = (int)findWays(0, 0, target, words, charFreq, dp);
        return res;
    }
}