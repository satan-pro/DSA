import java.util.*;
class gfgPrintLIS  // Printing the LIS
{
	// Using the LIS method to calculate dp and use a hash array to backtrack the LIS
	public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        // Code here
        int dp[] = new int[n];
        int hash[] = new int[n];

        Arrays.fill(dp, 1);
        
        for(int i=0; i<n; i++)
        	hash[i]=i;

        int ans = Integer.MIN_VALUE;
        int lastIndex=0;

        for(int i=0; i<n; i++)
        {
        	for(int prev=0; prev<=i-1; prev++)
        	{
        		if(arr[prev]<arr[i] && dp[i]<1+dp[prev])
        		{
        			dp[i] = 1+dp[prev];
        			hash[i] = prev;
        		}
        	}
        	if(dp[i]>ans)
        	{
        		ans=dp[i];
        		lastIndex=i;
        	}
        }

        ArrayList<Integer> res = new ArrayList<>();

        int current = lastIndex;
        while(current!=hash[current])
        {
        	res.add(arr[current]);
        	current = hash[current];
        }
        res.add(arr[current]);

        Collections.reverse(res);

        return res;
    }
}