import java.util.*;
class bw141q3
{
	public boolean isValid(String source, String pattern, boolean[] removed) {

		String st="";
		int j=0;
		for(int i=0; i<source.length(); i++)
		{
			if(!removed[i] && j<pattern.length() && source.charAt(i)==pattern.charAt(j))
			{
				j++;
			}
			if(j==pattern.length())
				return true;
		}
		return false;
	}
	public int maxRemovals(String source, String pattern, int[] targetIndices) {
        
        int n = source.length();
        int m = pattern.length();
        
        // Initialize dp array with 'infinity' equivalent
        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        
        // Boolean array to mark target indices
        boolean[] isTarget = new boolean[n];
        for (int idx : targetIndices) {
            isTarget[idx] = true;
        }
        
        // Dynamic programming to calculate the removals
        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                if (source.charAt(i) == pattern.charAt(j - 1) && dp[j - 1] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - 1] + (isTarget[i] ? 1 : 0));
                }
            }
        }
        
        // Result: number of removable indices or -1 if not possible
        return targetIndices.size() - (dp[m] == Integer.MAX_VALUE ? 0 : dp[m]);
    }
    public static void main(String[] args) {
    	bw141q3 obj = new bw141q3();
    	int res = obj.maxRemovals("yeyeykyded","yeyyd",new int[]{0,2,3,4});
    	System.out.println(res);
    }
}