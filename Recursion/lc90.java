import java.util.*;
class lc90
{
	List<Integer> sortSubset(List<Integer> subset)
	{
		int arr[] = new int[subset.size()];
		for(int i=0; i<subset.size(); i++)
		{
			arr[i]=subset.get(i);
		}
		Arrays.sort(arr);
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<arr.length; i++)
		{
			res.add(arr[i]);
		}
		return res;
	}

	void subsetFind(int ind, int[] nums, int n, List<List<Integer>> ans, List<Integer> subset)
	{
		if(ind>=n)
		{
			subset = sortSubset(subset);
			//System.out.println();
			ans.add(new ArrayList(subset));
			return;
		}
		subset.add(nums[ind]);
		subsetFind(ind+1, nums, n, ans, subset);
		subset.remove(subset.size()-1);
		subsetFind(ind+1, nums, n, ans, subset);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int n = nums.length;
        subsetFind(0,nums,n,ans,subset);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> i : ans)
        {
        	if(!res.contains(i))
        	{
        		res.add(i);
        	}
        }
        return res;
    }

    public static void main(String[] args) {
    	int arr[] = {4,1,0};
    	lc90 obj = new lc90();
    	List<List<Integer>> res = obj.subsetsWithDup(arr);
    	for(List<Integer> i : res)
    	{
    		for(int j=0; j<i.size(); j++)
    		{
    			System.out.print(i.get(j));
    		}
    		System.out.println();
    	}
    }
}