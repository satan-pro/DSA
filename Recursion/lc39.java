import java.util.*;
class lc39{
	 void func(int ind, int target, int n, int sum, int[] candidates, List<List<Integer>> ans, List<Integer> subset) {
        if (sum == target) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        if (sum > target || ind >= n) {
            return;
        }

        // Choose the current candidate
        subset.add(candidates[ind]);
        func(ind, target, n, sum + candidates[ind], candidates, ans, subset);
        subset.remove(subset.size() - 1);

        // Do not choose the current candidate and move to the next
        func(ind + 1, target, n, sum, candidates, ans, subset);
    }    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int n = candidates.length;
        func(0,target,n,0,candidates, ans, subset);
        return ans;
    }
}