import java.util.*;
class lc2044
{
	public void findBit(int ind, int bit, int maxVal, int[] nums, int[] count) {
		if(ind>=nums.length)
			return;

		int newBit = bit | nums[ind];

		if(newBit==maxVal)
			count[0]++;

		findBit(ind+1, bit, maxVal, nums, count);
		findBit(ind+1, newBit, maxVal, nums, count);
	}
	public int countMaxOrSubsets(int[] nums) {
		
		int maxVal = nums[0];
		for(int i=1; i<nums.length; i++)
		{
			maxVal = maxVal | nums[i];
		}        

		int count[] = new int[1];
		
		findBit(0, 0, maxVal, nums, count);

		return count[0];
    }
}