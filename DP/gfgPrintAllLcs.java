import java.util.*;
class gfgPrintAllLcs
{
	void findAll(int i, int j, int  maxLen, int dp[][], String s, String t, String st, Set<String> ans) {
		while(i>0 && j>0)
		{
			if(s.charAt(i-1)==t.charAt(j-1))
			{
				st=s.charAt(i-1)+st;
				i--;
				j--;
			}
			else 
			{
				if(dp[i-1][j]==dp[i][j-1])
				{
					findAll(i-1, j,  maxLen, dp, s, t, st, ans);
					findAll(i, j-1,  maxLen, dp, s, t, st, ans);
					return;
				}
				else if(dp[i-1][j]>dp[i][j-1])
				{
					i--;
				}
				else 
				{
					j--;
				}
			}
		}
		ans.add(st);
	}
	public List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
        int dp[][] = new int[s.length()+1][t.length()+1];

        for(int i=0; i<=s.length(); i++)
        {
        	for(int j=0; j<=t.length(); j++)
        	{
        		if(i==0 || j==0)
        			dp[i][j]=0;
        		else 
        		{
        			dp[i][j]=(s.charAt(i-1)==t.charAt(j-1))?1+dp[i-1][j-1]:Math.max(dp[i][j-1], dp[i-1][j]);
        		}
        	}
        }

        int maxLen = dp[s.length()][t.length()];
        Set<String> ans = new HashSet<>();
        findAll(s.length(), t.length(), maxLen,dp,s,t,"",ans);

        List<String> res = new ArrayList<>(ans);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
    	gfgPrintAllLcs obj = new gfgPrintAllLcs();
    	System.out.println(obj.all_longest_common_subsequences("baabaca", "abaaa"));
    }
}