import java.util.*;
class gfgGeekJump
{
	public int minimumEnergy(int arr[],int N){
        //code here
        int dp[] = new int[N];
        dp[0]=0;
        for(int i=1; i<N; i++)
        {
            int right=Integer.MAX_VALUE;
        	int left = dp[i-1]+Math.abs(arr[i]-arr[i-1]);
        	if(i>1)
        	    right = dp[i-2]+Math.abs(arr[i]-arr[i-2]);
        	dp[i]=Math.min(left, right);
        }
        return dp[N-1];
    }
}