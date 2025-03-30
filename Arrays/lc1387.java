import java.util.*;
class lc1387
{
	public int getKth(int lo, int hi, int k) {
        int arr[][] = new int[hi-lo+1][2];

        for(int i=lo; i<=hi; i++)
        {
        	arr[i-lo][0] = lo;

        	int x = i;
        	int count=0;
        	while(x>1)
        	{
        		if(x%2==0)
        			x/=2;
        		else
        			x = 3*x+1;
        		count++;
        	}

        	arr[i-lo][1] = count;
        }

        Arrays.sort(arr, (a,b)->{
        	if(a[1]==b[1])
        		return a[0]-b[0];
        	else 
        		return a[1]-b[1];
        });

        return arr[k][0];
    }
}