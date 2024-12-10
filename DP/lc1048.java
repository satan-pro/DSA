import java.util.*;
class lc1048  // Longest String Chain
{
	public boolean isValid(String w1, String w2) {

		int countDiff = 0;

		if(w2.length()!=w1.length()+1)
			return false;

		int i=0, j=0;
		while(i<w2.length() && j<w1.length())
		{
			if(w2.charAt(i)!=w1.charAt(j))
			{
				i++;
				countDiff++;

				if(countDiff>1)
					return false;
			}
			else
			{
				i++;
				j++;
			}
		}

		if(i<w2.length() || j<w1.length())
			countDiff++;

		return countDiff<=1;
	}
	public int longestStrChain(String[] words) {
        int dp[] = new int[words.length];
        Arrays.fill(dp, 1);

        Arrays.sort(words,(s1, s2)->s1.length()-s2.length());

        int ans = 0;
        for(int i=0; i<words.length; i++)
        {
        	for(int prev=0; prev<=i-1; prev++)
        	{
        		if(isValid(words[prev], words[i]))
        		{
        			dp[i] = Math.max(dp[i], 1+dp[prev]);
        		}
        	}
        	ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}