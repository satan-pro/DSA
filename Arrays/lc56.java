import java.util.*;
class lc56
{
	public int[][] merge(int[][] intervals) {
        
        int a[] = new int[intervals.length];
        int b[] = new int[intervals.length];

        for(int i=0; i<intervals.length; i++)
        {
        	a[i]=intervals[i][0];
        	b[i]=intervals[i][1];
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int count=0;

        for(int i=0; i<a.length-1; i++)
        {
        	if(b[i]>=a[i+1])
        	{
        		if(b[i]>=b[i+1])
        		{
        			b[i+1]=b[i];
        		}
        		a[i+1]=a[i];
        		a[i]=-1;
        		b[i]=-1;
        		count++;
        	}
        }

        int res[][] = new int[intervals.length-count][2];

        int k=0;
        for(int i=0; i<a.length; i++)
        {
        	if(a[i]>-1)
        	{
        		res[k][0]=a[i];
        		res[k][1]=b[i];
        		k++;
        	}
        }
        return res;
    }

}
