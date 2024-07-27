import java.util.*;
class lc1552
{
	boolean checkDistance(int gap, int m, int[] arr)
	{
		int prev=0;
		int balls=1;
		for(int i=1; i<arr.length; i++)
		{
			int curr = i;
			if(arr[i]-arr[prev]>=gap)
            {
                balls++;
                prev=curr;
            }
		}
		return (balls>=m)?true:false;
	}
	public int maxDistance(int[] position, int m) {
       Arrays.sort(position);
       int low = 1;
       int high = position[position.length-1]-position[0];
       int max=0;

       while(low<=high)
       {
       		int mid = (low+high)/2;
       		if(checkDistance(mid, m, position))
       		{
       			max=mid;
       			low=mid+1;
       		}
       		else 
       			high=mid-1;
       }
       return max;
    }
}