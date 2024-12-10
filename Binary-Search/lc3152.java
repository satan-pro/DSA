import java.util.*;
class lc3152
{
	public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        List<Set<Integer>> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        set.add(0);
        arr.add(set);

        for(int i=1; i<nums.length; i++)
        {	
        	if((nums[i-1]%2==0) != (nums[i]%2==0))
        	{
        		set = new HashSet<>();
        		arr.add(set);
        	}
        	set.add(i);
        }

        boolean res[] = new boolean[queries.length];
        for(int i=0; i<queries.length; i++)
        {
        	res[i]=false;
        	for(Set<Integer> s: arr)
        	{
        		if(s.contains(queries[i][0]) && s.contains(queries[i][1]))
        		{
        			res[i] = true;
        			break;
        		}
        	}
        }
        return res;
    }
}