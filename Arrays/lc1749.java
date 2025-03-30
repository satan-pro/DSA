import java.util.*;
class lc1749 // Maximum Absoulte Sum of Any Subarray
{
	// Apply Kadane's algorithm
	//  1. Apply Kadane's for maximum positive sum
	//  2. Apply Kadane's for minimum negative sum
	// Find the maximum of the absolute value of both
	public int maxAbsoluteSum(int[] nums) {
     	int maxSum=0, minSum=0;
     	int sum1 = 0;
     	int sum2 = 0;

     	for(int n: nums)
     	{
     		sum1+=n;
     		sum2+=n;
     		maxSum = Math.max(sum1, maxSum);
     		minSum = Math.min(sum2, minSum);

     		if(sum1<0)
     			sum1=0;
     		if(sum2>0)
     			sum2=0;
     	}   

     	return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}