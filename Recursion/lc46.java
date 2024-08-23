import java.util.*;
class lc46
{
	// void swap(int i, int n, int[] arr)
	// {
	// 	int temp = arr[i];
	// 	arr[i]=arr[n];
	// 	arr[n]=temp;
	// }
	// void permuteRecur(int ind, int[] nums, List<List<Integer>> ans)
	// {
	// 	if(ind==nums.length)
	// 	{
	// 		List<Integer> ds = new ArrayList<>();
	// 		for(int i=0; i<nums.length; i++)
	// 			ds.add(nums[i]);
	// 		ans.add(new ArrayList<>(ds));
	// 		return;
	// 	}
	// 	for(int i=ind; i<nums.length; i++)
	// 	{
	// 		swap(ind, i, nums);
	// 		permuteRecur(ind+1, nums, ans);
	// 		swap(ind, i, nums);
	// 	}
	// }
	void swap(int i, int n, char[] arr)
	{
		char temp = arr[i];
		arr[i]=arr[n];
		arr[n]=temp;
	}
	void permuteRecur(int ind, char[] nums, List<List<Character>> ans)
	{
		if(ind==nums.length)
		{
			List<Character> ds = new ArrayList<>();
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
	public List<List<Character>> permute(char[] nums) {
        List<List<Character>> ans = new ArrayList<>();
        permuteRecur(0,nums, ans);
        return ans;
    }

    public static void main(String[] args) {
    	char arr[] = {'s', 'e', 'n', 'n', 'o', 'y', 'p', 'f', 'u', 'n', 'r'};
    	lc46 obj = new lc46();
    	List<List<Character>> ans = obj.permute(arr);
    	for(List<Character> i : ans)
    	{
    		System.out.print("[");
    		for(int j=0; j<i.size(); j++)
    			System.out.print(i.get(j)+",");
    		System.out.print("],");
    	}
    }
}