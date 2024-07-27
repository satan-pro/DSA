import java.util.*;
class cnNthRoot
{
	static int findPower(int k, int n, int m)
	{
		long ans=1;
		for(int i=1; i<=n; i++)
		{
			ans=ans*k;
			if(ans>m)
				return -1;
			if(ans==m)
				return 1;
		}
		return 0;
	}

	public static int NthRoot(int n, int m) {
        // Write your code here.
        int low=1, high=m;
        while(low<=high)
        {
        	int mid = (low+high)/2;
        	int midPow = findPower(mid, n, m);
        	if(midPow==1)
        		return mid;
        	else if(midPow==0)
        		low=mid+1;
        	else
        		high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
    	int res = NthRoot(4,64);
    	System.out.println(res);
    }
}