import java.util.*;
class lc540
{
	int findUnique(int[] nums, int low, int high)
	{
		int mid = (low+high)/2;
		if(low==high)
			return low;
		if(mid%2==1)
			mid--;
		if(nums[mid+1]==nums[mid])
			return findUnique(nums, mid+2, high);
		else 
			return findUnique(nums, low, mid);
	}
	public int singleNonDuplicate(int[] nums) {
        int res = findUnique(nums, 0, nums.length-1);
        return nums[res];
    }

    public static void main(String[] args) {
    	lc540 obj = new lc540();
    	int arr[] = {1,2,2,3,3,4,4,8,8};
    	int res = obj.singleNonDuplicate(arr);
    	System.out.println(res);
    }
}