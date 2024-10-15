import java.util.*;
class cnAllocateBooks
{
	static int isValid(ArrayList<Integer> arr, int k, int m)
	{
		int count=1;
		int valSum=0;
		for(int i=0; i<arr.size(); i++)
		{
			if(valSum+arr.get(i)<=k)
				valSum+=arr.get(i);
			else 
			{
				count++;
				valSum=arr.get(i);
			}
		}
		if(count==m)
			return 1;
		return count>m?-1:0;
	}
	public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(n<m)
        	return -1;

        int high=0;
        int low=Integer.MAX_VALUE;
        for(int i:arr)
        {
        	high+=i;
        	low = Math.min(low, i);
        }

        int ans=0;
        while(low<=high)
        {
        	int mid=(low+high)/2;
        	int pages = isValid(arr, mid, m);
        	if(pages==1)
        	{
        		ans=mid;
        		low=mid+1;
        	}
        	else if(pages==0)
        	{
        		high=mid-1;
        	}
        	else 
        		low=mid+1;
        }
        return ans;
    }
}