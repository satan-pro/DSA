import java.util.*;
class lc2035
{
	public int minimumDifference(int[] nums) {
        
        int sum=0;
        int minElement=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++)
        {
        	sum+=nums[i];
            minElement = Math.min(minElement, nums[i]);
        }

        int offset = minElement<0?-minElement:0;
        int range = sum+offset;

        boolean dp[][] = new boolean[nums.length][range+1];

        if(nums[0]<=range)
        {
            if(offset<0)
        	   dp[0][nums[0]+offset]=true;
            else
                dp[0][nums[0]]=true;
        }

        for(int i=1; i<nums.length; i++)
        {
        	for(int j=0; j<=range; j++)
        	{
        		if(j==0)
        			dp[i][j]=true;
        		else 
        		{
        			boolean notPick = dp[i-1][j];
        			boolean pick = false;
        			if(nums[i]<=j)
                    {
                        if(nums[i]<0)
        				    pick = dp[i-1][j-nums[i]+offset];
                        else 
                            pick = dp[i-1][j-nums[i]];
                    }

        			dp[i][j] = pick||notPick;
        		}
        	}
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=range; i++)
        {
        	if(dp[nums.length-1][i])
        	{
                int actualSum = i-offset;
        		int diff = Math.abs(actualSum-(sum-actualSum));
        		min = Math.min(min, diff);
        	}
        }
        return min;
    }
}