import java.util.*;
class lc46
{
	void swap(int i, int n, int[] arr)
	{
		int temp = arr[i];
		arr[i]=arr[n];
		arr[n]=temp;
	}
	void permuteRecur(int ind, int[] nums, List<List<Integer>> ans)
	{
		if(ind==nums.length)
		{
			List<Integer> ds = new ArrayList<>();
			for(int i=0; i<nums.length; i++)
				ds.add(nums[i]);
			ans.add(new ArrayList<>(ds));
			return;
		}
		for(int i=ind; i<nums.length; i++)
		{
			swap(ind, i, nums);
			permuteRecur(ind+1, nums, ans);
			swap(ind, i, nums);
		}
	}
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteRecur(0,nums, ans);
        return ans;
    }

    public static void main(String[] args) {
    	int arr[] = {1,2,3};
    	lc46 obj = new lc46();
    	List<List<Integer>> ans = obj.permute(arr);
    	for(List<Integer> i : ans)
    	{
    		System.out.print("[");
    		for(int j=0; j<i.size(); j++)
    			System.out.print(i.get(j)+",");
    		System.out.print("],");
    	}
    }
}