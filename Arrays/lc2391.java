import java.util.*;
class lc2391
{
	public int garbageCollection(String[] garbage, int[] travel) {
        int p,g,m;
        p=g=m=0;

        int prefixSum[] = new int[garbage.length];
        prefixSum[0]=0;
        for(int i=1; i<garbage.length; i++)
        {
        	prefixSum[i] = prefixSum[i-1]+travel[i-1];
        }

        int totalMinutes=0;

        for(int i=0; i<garbage.length; i++)
        {
        	int mCount, pCount, gCount;
        	mCount=pCount=gCount=0;

        	for(int j=0; j<garbage[i].length(); j++)
        	{
        		char ch = garbage[i].charAt(j);
        		if(ch=='M')
        			mCount++;
        		if(ch=='P')
        			pCount++;
        		if(ch=='G')
        			gCount++;
        	}

        	if(garbage[i].indexOf('M')!=-1)
        	{
        		totalMinutes+=(prefixSum[i]-prefixSum[m]);
        		m=i;
        		totalMinutes+=mCount;
        	}
        	if(garbage[i].indexOf('P')!=-1)
        	{
        		totalMinutes+=(prefixSum[i]-prefixSum[p]);
        		p=i;
        		totalMinutes+=pCount;
        	}
        	if(garbage[i].indexOf('G')!=-1)
        	{
        		totalMinutes+=(prefixSum[i]-prefixSum[g]);
        		g=i;
        		totalMinutes+=gCount;
        	}

        }
        return totalMinutes;
    }
}