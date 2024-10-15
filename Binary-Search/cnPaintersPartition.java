import java.util.*;
class cnPaintersPartition
{
	static boolean isValid(ArrayList<Integer> boards, int t, int k)
	{
		int valSum=0;
		int count=1;
		for(int i=0; i<boards.size(); i++)
		{
			if(valSum+boards.get(i)<=t)
				valSum+=boards.get(i);
			else 
			{
				count++;
				valSum=boards.get(i);
			}
			if(count>k)
				return false;
		}
		return count<=k;
	}
	public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i:boards)
        {
        	high+=i;
        	low = Math.max(low, i);
        }

        int ans=0;
        while(low<=high)
        {
        	int mid=(low+high)/2;
        	if(isValid(boards, mid, k))
        	{
        		ans=mid;
        		high=mid-1;
        	}
        	else 
        		low=mid+1;
        }
        return ans;
    }
}