import java.util.*;
class lc2940
{
	// Brute Force Approach
	public int[] leftmostBuildingQueries1(int[] heights, int[][] queries) {
        int res[] = new int[queries.length];

        for(int i=0; i<queries.length; i++)
        {
        	int a = queries[i][0];
        	int b = queries[i][1];

        	boolean found = false;
            if(a>b)
            {
                int temp = a;
                a = b;
                b = temp;
            }
        	if(heights[a]<heights[b] || a==b)
        		res[i] = b;
        	else 
        	{
        		outer: for(int j=b+1; j<heights.length; j++)
        		{
                    System.out.println(heights[j]);
        			if(heights[j]>heights[a] && heights[j]>heights[b])
        			{
        				found=true;
        				res[i] = j;
                        break outer;
        			}
        		}
        		if(!found)
        			res[i] = -1;
        	}
        }

        return res;
    }

    // Stack Approach: Next Greater Element
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
    	int nge[] = new int[heights.length];
    	int res[] = new int[queries.length];
    	Arrays.fill(nge, -1);
    	Stack<Integer> st = new Stack<>();

    	// Create the NGE array for the buildings with increasing height
    	for(int i=heights.length-1; i>=0; i--)
    	{
    		while(!st.isEmpty() && heights[st.peek()]<heights[i])
    			st.pop();

    		if(!st.isEmpty())
    			nge[i] = st.peek();

    		st.push(i);
    	}

    	// Find the result
    	for(int i=0; i<queries.length; i++)
    	{
    		int a = queries[i][0];
    		int b = queries[i][1];
    		int maxHeight = Math.max(heights[a], heights[b]);
    		// Start from the latter index 
    		int j = Math.max(a,b)+1;

    		// Find the NGE after the start index i.e. j
    		while(j!=-1 && j<heights.length && heights[j]<maxHeight)
    			j = nge[j];

    		res[i] = (j!=-1 && j<heights.length)?j:-1;
    	}

    	return res;
    }
}