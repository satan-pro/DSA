import java.util.*;
class lc1590
{
	// Intuition: Find the subarray whose sum is (totalSum % p), then the remaining subarray will be divisible by p
	// Procedure: Find the totalSum, check is if it fully divisible then return 0
	// Find the prefixSum for every element in the array. Store the (prefixSum % p) in a HashMap
	// Now we need to find the subarray such that (prefixSum[j] - prefixSum[i] == rem)
	// We already have a map of previous prefixSum so we need to find prefixSum[i] = (prefixSum[j] - rem) from the above equation
	// Find if the given prefixSum exists in the map, if so update the minLength with (j-i)
	// If the minLength is equal to array size return -1
	public int minSubarray(int[] nums, int p) {
        long arrSum = 0;
        for(int n:nums)
        	arrSum+=n;

        int rem = (int)(arrSum%p);
        if(rem==0)
        	return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        long prefixSum=0;
        map.put(0, -1);
        int minLength = nums.length;

        for(int i=0; i<nums.length; i++)
        {
        	prefixSum+=nums[i];
        	int currSum = (int)(prefixSum%p);
        	int targetSum = (currSum-rem+p)%p;

        	if(map.containsKey(targetSum))
        		minLength = Math.min(minLength, i-map.get(targetSum));

        	map.put(currSum, i);
        }

        return minLength==nums.length?-1:minLength;
    }

    public static void main(String[] args) {
    	lc1590 obj = new lc1590();
    	int arr[] = {1000000000,1000000000,1000000000};
    	int res = obj.minSubarray(arr, 3);
    	System.out.println(res);
    }
}