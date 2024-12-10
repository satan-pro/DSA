import java.util.*;
class lc368
{
	public List<Integer> largestDivisibleSubset(int[] nums) {
        int dp[] = new int[nums.length];
        int hash[] = new int[nums.length];

        Arrays.fill(dp, 1);

        for(int i=0; i<hash.length; i++)
        	hash[i]=i;

        int ans = Integer.MIN_VALUE;
        int lastIndex = 0;

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++)
        {
        	for(int prev=0; prev<=i-1; prev++)
        	{
        		if(nums[i]%nums[prev]==0 && dp[i]<1+dp[prev])
        		{
        			dp[i] = 1+dp[prev];
        			hash[i] = i;
        		}
        	}
        	if(dp[i]>ans)
        	{
        		ans=dp[i];
        		lastIndex=i;
        	}
        }

        List<Integer> res = new ArrayList<>();
        
        int current = lastIndex;
        while(current!=hash[current])
        {
        	res.add(nums[current]);
        	current = hash[current];
        }

        res.add(nums[current]);

        Collections.reverse(res);

        return res;
    }
}