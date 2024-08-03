import java.util.*;
class lc1423 // Maximum Points you can obtain from cards
{
	// Take a Sliding Window from first to k elements and move it backwards, so that i goes to 0 and j goes to len(arr)-k
	public int maxScore(int[] cardPoints, int k) {
		int windowSum=0;
		int sum=0;
		int maxSum=0;
		for(int i=0; i<k; i++)
			windowSum+=cardPoints[i];
		int i=k-1;
		int j=cardPoints.length-1;
		int sum1=windowSum, sum2=0;
		maxSum = windowSum;

		// The window rotates around the array and calculates the sum at each iteration and updates the maxSum
		while(i>=0)
		{
			sum1-=cardPoints[i];
			sum2+=cardPoints[j];
			i--;
			j--;

			maxSum= Math.max(maxSum, sum1+sum2);
		}
		return maxSum;
	}
}