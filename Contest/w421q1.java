import java.util.*;
class w421q1
{
	 public int gcd(int a, int b) {
        return b==0? a: gcd(b, a%b);
    }
    public long lcm(long a, long b) {
        return a * (b/gcd((int)a,(int)b));
    }
    public long lcmArray(int[] arr) {
    	long res = arr[0];

    	for(int i=0; i<arr.length; i++)
    	{
    		res = lcm(res, arr[i]);
    	}
    	return res;
    }
    public long maxScore(int[] nums) {
        int n = nums.length;

        if(n==1)
        	return (long)nums[0]*nums[0];

        int[] prefixGCD = new int[n];
        prefixGCD[0] = nums[0];

        for(int i=1; i<n; i++)
        {
        	prefixGCD[i] = gcd(prefixGCD[i-1], nums[i]);
        }

        int[] suffixGCD = new int[n];
        suffixGCD[n-1] = nums[n-1];

        for(int i=n-2; i>=0; i--)
        {
        	suffixGCD[i] = gcd(suffixGCD[i+1], nums[i]);
        }

        long totalLCM = lcmArray(nums);

        long maxFactorScore = totalLCM * prefixGCD[n-1];

        for(int i=0; i<n; i++)
        {
        	int gcdWithout;
        	if(i==0)
        		gcdWithout = suffixGCD[1];
        	else if(i==n-1)
        		gcdWithout = suffixGCD[n-2];
        	else 
        		gcdWithout = gcd(prefixGCD[i-1], suffixGCD[i+1]);

        	long factorScoreWithout = totalLCM * gcdWithout;
        	maxFactorScore = Math.max(maxFactorScore, factorScoreWithout);
        }
        return maxFactorScore;
    }
}