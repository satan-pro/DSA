import java.util.*;
class lc287
{
	public int findDuplicate(int[] nums) {

		boolean res[] = new boolean[nums.length];
		for(int num:nums)
		{
			if(res[num])
			{
				return num;
			}
			res[num]=true;
		}
		return 0;
	}

	public static void main(String[] args) {
		lc287 obj = new lc287();
		int arr[] = {1,3,4,2,2,5};
		int res = obj.findDuplicate(arr);
		System.out.println(res);
	}
}