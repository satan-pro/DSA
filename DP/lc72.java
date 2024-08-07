import java.util.*;
class lc72  // Edit Distance
{
	// Intuition : There are 3 operations that can be performed on the string: insertion, deletion, replacement, so all these three operations have to be used in the recursive case

	// Base Case : If string1 runs out, it means there are more characters to be inserted, so return j+1
	// If string2 gets finished, it means you dont need extra characters in strin1 which are meant to be deleted, so return i+1

	// Match : If characters of both the strings match at the same time, then do not perform any operation and shift both indexes by 1, so it is 0 + f(i-1, j-1)
	// Insertion : Insert a character before the current character and then you have to come back down to the main character and shift the second strings character by 1, so it is 1 + f(i, j-1)
	// Deletion : When you delete a character the first string index moves by 1 but second string index remians same, so it is 1 + f(i-1, j)
	// Replacement : When you replace a character by the same character of the second string, it matches and both the index move by 1, so it is 1 + f(i-1, j-1)
	// Find the min of all three recursive cases

	// Memoization Approach 
	int findMin(int i, int j, String word1, String word2, int[][] dp)
	{
		if(i<=0)
			return j;
		if(j<=0)
			return i;
		if(dp[i][j]!=-1)
			return dp[i][j];

		if(word1.charAt(i-1)==word2.charAt(j-1))
			return dp[i][j] = 0+findMin(i-1, j-1, word1, word2, dp);
		return dp[i][j] = 1+Math.min(findMin(i-1, j-1, word1, word2, dp), Math.min(findMin(i-1, j, word1, word2, dp), findMin(i, j-1, word1, word2, dp)));
	}
	public int minDistance1(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int[] arr: dp)
        	Arrays.fill(arr, -1);

        int res = findMin(word1.length(), word2.length(), word1, word2, dp);
        return res;
    }

    // Tabulation Approach
    public int minDistance2(String word1, String word2) {
    	int dp[][] = new int[word1.length()+1][word2.length()+1];

    	// Base Case Initilization
    	for(int i=1; i<=word1.length(); i++)  // If string2 gets finished
    		dp[i][0] = i; 
    	for(int j=1; j<=word2.length(); j++)  // If string1 gets finished
    		dp[0][j] = j;

    	for(int i=1; i<=word1.length(); i++)
    	{
    		for(int j=1; j<=word2.length(); j++)
    		{
    			if(word1.charAt(i-1)==word2.charAt(j-1))
    				dp[i][j] = dp[i-1][j-1];
    			else 
    				dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
    		}
    	}
    	return dp[word1.length()][word2.length()];
    }

    // Space Optimization
    public int minDistance(String word1, String word2) {
    	int dp[] = new int[word2.length()+1];

    	// Base Case Initilization
    	for(int i=0; i<=word2.length(); i++)
    		dp[i] = i;

    	for(int i=1; i<=word1.length(); i++)
    	{
    		int curr[] = new int[word2.length()+1];
            curr[0] = i;
    		for(int j=1; j<=word2.length(); j++)
    		{
    			if(word1.charAt(i-1)==word2.charAt(j-1))
    				curr[j] = dp[j-1];
    			else 
    				curr[j] = 1+Math.min(dp[j-1], Math.min(dp[j], curr[j-1]));
    		}
    		dp = Arrays.copyOf(curr, curr.length);
    	}
    	return dp[word2.length()];
    }
}