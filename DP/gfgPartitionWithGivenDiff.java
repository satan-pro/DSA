import java.util.*;
class gfgPartitionWithGivenDiff
{
	public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int mod = (int)(Math.pow(10,9)+7);
        int sum=0;
        for(int i=0; i<n; i++)
        	sum+=arr[i];

        if((sum<d)||((sum-d)%2==1)) // return 0 if required case is not fulfilled
        	return 0;

        int target = (sum-d)/2; // get this formula by solving 2 equations ; s1=sum-s2; s1+s2=sum-d; 

        int dp[][] = new int[n][target+1];

        // Base Case initialization from lc2035
        if(arr[0]==0)
        	dp[0][arr[0]]=2;
        else 
        	dp[0][0]=1;

        if(arr[0]!=0 && arr[0]<=target)
        	dp[0][arr[0]]=1;

        for(int i=1; i<n; i++)
        {
        	for(int j=0; j<=target; j++)
        	{
        			int pick=0;
        			int notPick = dp[i-1][j];
        			if(arr[i]<=j)
        				pick=dp[i-1][j-arr[i]];

        			dp[i][j] = (pick+notPick)%mod;
        		
        	}
        }

        return dp[n-1][target];
    }
}