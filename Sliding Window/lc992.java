import java.util.*;
class lc992  // Subarrays with K Different Integers
{
	int countUnique(int nums[], int k)
	{
		 int i,j;
        i=j=0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        while(j<nums.length)
        {
        	map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

        	while(map.size()>k)
        	{
        		map.replace(nums[i], map.get(nums[i])-1);
        		if(map.get(nums[i])==0)
        			map.remove(nums[i]);
        		i++;
        	}

        	if(map.size()<=k)
        		count += j-i+1;
        	j++;
        }
        return count;
	}
	public int subarraysWithKDistinct(int[] nums, int k) {

		if(k==0)
			return 0;
		int less = countUnique(nums, k-1);
		int more = countUnique(nums, k);
		return more-less;
    }
}