import java.util.*;
class lc115
{
	int findDistinct(int i, int j, String s, String t, int[][] dp)
	{
		if(i<0)
			return 0;
		if(j<0)
			return 1;
		if(dp[i][j]!=-1)
			return dp[i][j];

		if(s.charAt(i)==t.charAt(j))
			return dp[i][j] = findDistinct(i-1, j-1, s, t, dp)+findDistinct(i-1, j, s, t, dp);
		else 
			return dp[i][j] = findDistinct(i-1, j, s, t, dp);

	}
	public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];

        for(int[] arr:dp)
        	Arrays.fill(arr, -1);

        int res = findDistinct(s.length()-1, t.length()-1, s, t, dp);
        return res;
    }
}