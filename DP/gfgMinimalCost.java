import java.util.*;
class gfgMinimalCost
{
	public int minimizeCost(int arr[],int N,int K){
        //code here
        int dp[] = new int[N];
        dp[0]=0;
        for(int i=1; i<N; i++)
        {
        	int min = Integer.MAX_VALUE;
        	if(K>1)
        	{
	        	for(int j=1; j<=K; j++)
	        	{
	        		int jump = Integer.MAX_VALUE;
	        		if(i>=j)
	        			jump = dp[i-j]+Math.abs(arr[i]-arr[i-j]);
	        		min=Math.min(jump,min);
	        	}
        	}
        	else
        	{
        		min = dp[i-1]+Math.abs(arr[i]-arr[i-1]);
        	}
        	dp[i]=min;
        }
        return dp[N-1];
    }

    public static void main(String[] args) {
    	
    }
}