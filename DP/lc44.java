import java.util.*;
class lc44
{
	boolean starCheck(String p, int j)
	{
		for(int i=0; i<=j; i++)
		{
			if(p.charAt(i)!='*')
				return false;
		}
		return true;
	}
	int findMatch(int i, int j, String s, String p, int dp[][])
	{
		if(i<0 && j<0)
			return 1;
		if(i>=0 && j<0)
			return 0;
		if(i<0 && j>=0)
			return starCheck(p, j)?1:0;
		if(dp[i][j]!=-1)
			return dp[i][j];

		if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
			return dp[i][j] = findMatch(i-1, j-1, s, p, dp);
		else if(p.charAt(j)=='*')
		{
			dp[i][j] = (findMatch(i, j-1, s, p, dp)==1 || findMatch(i-1, j, s, p, dp)==1)?1:0;
			return dp[i][j];
		}
		else 
			return 0;
	}
	public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];

        for(int[] arr: dp)
        	Arrays.fill(arr, -1);
        
        int res = findMatch(s.length()-1, p.length()-1, s, p, dp);
        return res==1?true:false;
    }
}