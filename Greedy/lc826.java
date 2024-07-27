import java.util.*;
class lc826
{
	class hybridArray
	{
		int diff;
		int profit;
		public hybridArray(int n, int m)
		{
			this.diff=n;
			this.profit=m;
		}
	}
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		hybridArray zip[] = new hybridArray[difficulty.length];

		for(int i=0; i<difficulty.length; i++)
		{
			zip[i] = new hybridArray(difficulty[i], profit[i]);
		}

        Arrays.sort(zip, new Comparator<hybridArray>(){
        	@Override
        	public int compare(hybridArray h1, hybridArray h2)
        	{
        		return Integer.compare(h2.profit, h1.profit);
        	}
        });

        for(int i=0; i<difficulty.length; i++)
        {
        	difficulty[i]=zip[i].diff;
        	profit[i]=zip[i].profit;
        }

        int sum=0;
        for(int i=0; i<worker.length; i++)
        {
        	int j=0;
        	while(j<profit.length)
        	{
        		if(difficulty[j]>worker[i])
        		{
        			j++;
        			continue;
        		}
        		break;
        	}
        	if(j>=profit.length)
        		continue;
        	sum+=profit[j];
        }
        return sum;
    }

    public static void main(String[] args) {
    	lc826 obj = new lc826();
    	int diff[] = {2,4,6,8,10};
    	int profit[] = {10,20,30,40,50};
    	int worker[] = {4,5,6,7};

    	int res = obj.maxProfitAssignment(diff,profit,worker);
    	System.out.println(res);
    }
}