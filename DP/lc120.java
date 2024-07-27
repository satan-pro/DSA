import java.util.*;
class lc120
{
	// Memoization Approach
	int findMinPath(int i, int j, List<List<Integer>> triangle , List<List<Integer>> dp) {
		if(i==0)
			return triangle.get(i).get(0);
		if(j<0 || j>=triangle.get(i).size())
			return (int)Math.pow(10,8);
		if(dp.get(i).get(j)!=-1)
			return dp.get(i).get(j);

		int same = triangle.get(i).get(j)+findMinPath(i-1, j, triangle, dp);
		int adj = triangle.get(i).get(j)+findMinPath(i-1, j-1, triangle, dp);
		
		dp.get(i).set(j, Math.min(same, adj));
		return dp.get(i).get(j);
	}

	public int minimumTotal1(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        int n = triangle.size();

        for(int i=0; i<n; i++)
        {
        	dp.add(new ArrayList<>());
        	for(int j=0; j<triangle.get(i).size(); j++)
        	{
        		dp.get(i).add(-1);
        	}
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<triangle.get(n-1).size(); i++)
        {
        	res = Math.min(res, findMinPath(n-1, i, triangle, dp));
        } 
        return res;
    }

    // Tabulation Approach
    public int minimumTotal2(List<List<Integer>> triangle) {

    	List<List<Integer>> dp = new ArrayList<>();
    	int n = triangle.size();

    	for(int i=0; i<n; i++)
        {
        	dp.add(new ArrayList<>());
        	for(int j=0; j<triangle.get(i).size(); j++)
        	{
        		dp.get(i).add(-1);
        	}
        }

    	for(int i=0; i<n; i++)
    	{
    		dp.add(new ArrayList<>());
    		for(int j=0; j<triangle.get(i).size(); j++)
    		{
    			if(i==0)
    				dp.get(i).set(j, triangle.get(i).get(j));
    			else
    			{
    				int same = Integer.MAX_VALUE, adj = Integer.MAX_VALUE;

    				if(j<=triangle.get(i-1).size()-1)
    					same = triangle.get(i).get(j)+dp.get(i-1).get(j);
    				if(j>0)
    					adj = triangle.get(i).get(j)+dp.get(i-1).get(j-1);

    				dp.get(i).set(j, Math.min(same, adj));
    			}
    		}
    	}

    	int res = Integer.MAX_VALUE;
    	for(int i=0; i<triangle.get(n-1).size(); i++)
    	{
    		res = Math.min(res, dp.get(n-1).get(i));
    	}
    	return res;
    }

    // Space Optimization
    public int minimumTotal(List<List<Integer>> triangle) {

    	List<Integer> dp = new ArrayList<>();
    	int n = triangle.size();

    	dp.add(triangle.get(0).get(0));

    	for(int i=1; i<n; i++)
    	{
    		List<Integer> curr = new ArrayList<>();
    		for(int j=0; j<triangle.get(i).size(); j++)
    		{
				int same = Integer.MAX_VALUE, adj = Integer.MAX_VALUE;

				if(j<=triangle.get(i-1).size()-1)
					same = triangle.get(i).get(j)+dp.get(j);
				if(j>0)
					adj = triangle.get(i).get(j)+dp.get(j-1);

				curr.add(Math.min(same, adj));
    		}
    		dp = new ArrayList<>(curr);
    	}

    	int res = Integer.MAX_VALUE;
    	for(int i=0; i<triangle.get(n-1).size(); i++)
    	{
    		res = Math.min(res, dp.get(i));
    	}
    	return res;
    }
}