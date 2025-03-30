import java.util.*;
class lc26  // Remove Duplicate from Sorted Array
{
	public int removeDuplicates(int[] nums) {
        int i=0, j=1;

        while(j<nums.length)
        {
        	// Slide the window if same number is encountered
           while(j<nums.length && nums[j]==nums[j-1])
           	j++;

           // Set the number as the non-duplicate incremental number
           if(j<nums.length && nums[j]!=nums[i])
           	 nums[++i] = nums[j];

        	j++;
        }

        // return no of unique numbers in the array
        return i+1;
    }
}