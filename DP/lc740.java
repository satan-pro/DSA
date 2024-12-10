import java.util.*;
class lc740
{
	public int findMax(int i, int[] nums, int[] freq, int[] dp) {
		if(i<0)
			return 0;
		if(dp[i]!=-1)
			return dp[i];

		int pick = nums[i]*freq[i];
		if(i>0 && nums[i]==nums[i-1]+1)
			pick += findMax(i-2, nums, freq, dp);
		else 
			pick += findMax(i-1, nums, freq, dp);

		int notPick = findMax(i-1, nums, freq, dp);

		return dp[i] = Math.max(pick, notPick);
	}
	public int deleteAndEarn(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i: nums) 
        {
        	map.put(i, map.getOrDefault(i, 0)+1);
        }

        int elems[] = new int[map.size()];
        int freq[] = new int[map.size()];

        int i=0;
        for(Map.Entry<Integer, Integer> ent: map.entrySet())
        {
        	elems[i] = ent.getKey();
        	freq[i] = ent.getValue();
        	i++;
        }

        int res = findMax(elems.length-1, elems, freq, dp);
        return res;
    }
}