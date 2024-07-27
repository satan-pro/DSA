import java.util.*;
class lc40{
	void func(int ind, int target, int n, int[] candidates, List<List<Integer>> ans, List<Integer> subset)
	{
		if(target==0)
		{
			Collections.sort(subset);
			if(!ans.contains(subset))
				ans.add(new ArrayList(subset));
			return;
		}
		for(int i=ind; i<candidates.length; i++)
		{
			if(i>ind && candidates[i]==candidates[i-1])
				continue;
			if(candidates[i]>target)
				break;

			subset.add(candidates[i]);
			func(i+1,target-candidates[i],n,candidates,ans,subset);
			subset.remove(subset.size()-1);
		}
	}
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	 	List<List<Integer>> ans = new ArrayList();
	 	int n = candidates.length;
	 	Arrays.sort(candidates);
	 	func(0,target,n,candidates,ans,new ArrayList<>());
	 	return ans;
	}
	
        
    
}