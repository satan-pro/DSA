import java.util.*;
class lc1423
{
	public int maxScore(int[] cardPoints, int k) {
		
		int i=0, j=cardPoints.length-1;
		if(k==0)
			return 0;
     	if(k==1)
     		return Math.max(cardPoints[i], cardPoints[j]);
     	if(k==cardPoints.length)
            return Arrays.stream(cardPoints).sum();
    	int windowSum=0;
     	for(; i<k; i++)
     	{
     		windowSum+=cardPoints[i];
     	}
     	int max = windowSum;
     	int sum1=windowSum, sum2=0;
     	while(i>=0)
     	{
     		sum1-=cardPoints[i];
     		sum2+=cardPoints[j];
     		i--;
     		j--;
     		max= Math.max(max, sum1+sum2); 
     	}
     	return max;
    }
}