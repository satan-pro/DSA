import java.util.*;
class lc1422  // Maximum Score After Splitting a String
{
	public int maxScore(String s) {
		// Create 2 prefix arrays of zeros and ones
        int zeros[] = new int[s.length()];
        int ones[] = new int[s.length()];

        if(s.charAt(0)=='0')
        	zeros[0]++;
        else 
        	ones[0]++;

        // Build both the prefix arrays
        for(int i=1; i<s.length(); i++)
        {
        	char ch = s.charAt(i);

        	zeros[i] = zeros[i-1];
        	ones[i] = ones[i-1];

        	if(ch=='0')
        		zeros[i]++;
        	else if(ch=='1')
        		ones[i]++;
        }

        // Find the max count of ones in the entire string
        int oneCount = ones[ones.length-1];
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<s.length()-1; i++)
        {
        	// For each index find the sum of the prefixSum of zeros and the remaining sum of ones 
        	int currSum = zeros[i]+(oneCount-ones[i]);
        	maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}