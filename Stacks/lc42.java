import java.util.*;
class lc42  // Trapping Rainwater
{
	public int trap1(int[] height) {
        Stack<Integer> st = new Stack<>();
        int max = height[0];

        int vol=0;
        boolean ignore=true;
        for(int i=0; i<height.length; i++)
        {
        	while(height[i]>max && st.size()>1)
        	{
        		int popVal = st.pop();
        		if(height[i]>max)
        			ignore=false;
        		if(!ignore)
        			vol+=(max-popVal);
        		if(popVal==max)
        			max=height[i];
        		
        	}
        	st.push(height[i]);
        	max = Math.max(max, height[i]);
        }

        Stack<Integer> st2 = new Stack<>();
        max = st.peek();
        ignore=true;
        while(!st.isEmpty())
        {
        	int currHeight = st.pop();
        	while(currHeight>max && !st2.isEmpty())
        	{
        		int currVal = st2.pop();
        		if(currHeight>max)
        			ignore=false;
        		if(!ignore)
        			vol+=(max-currVal);
        		if(currVal==max)
        			max=currHeight;
        		System.out.println(currVal + " " + currHeight + " " + max + " " + vol + " "+ignore);
        	}
        	st2.push(currHeight);
        	max = Math.max(max, currHeight);
        	System.out.println(currHeight);
        }
        return vol;
    }
    // public int trap(int[] height) {
	// 	int n = height.length;
    //     int suffixMax[] = new int[height.length];
    //     suffixMax[n-1] = height[n-1];
    //     for(int i=n-2; n>=0; n++)
    //     {
    //     	suffixMax[i] = Math.max(height[i], suffixMax[i+1]);
    //     }

    //     int leftMax = height[0];
    //     int res=0;

    //     for(int i=0; i<n; i++)
    //     {
    //     	leftMax = Math.max(height[i], leftMax);
    //     	if(height[i]<leftMax && height[i]<suffixMax[i])
    //     		res+=leftMax-height[i];
    //     }
    //     return res;
    // }
    public int trap2(int height[]) {
    	int n = height.length;
    	Stack<Integer> st = new Stack<>();
    	int vol=0;

    	for(int i=0; i<height.length; i++)
    	{
    		while(!st.isEmpty() && height[i]>height[st.peek()])
    		{
    			int top = st.pop();
    			if(st.isEmpty())
    				break;
    			int dist = i-st.peek()-1;
    			int weight = Math.min(height[i], height[st.peek()])-height[top];
    			vol+=dist*weight;
    		}
    		st.push(i);
    	}
    	return vol;
    }
    public int trap(int height[]) {
    	int n = height.length;
    	int l=0, r=n-1;
    	int lmax=0, rmax=0;
    	int vol=0;

    	while(l<r)
    	{
    		if(height[l]<=height[r])
    		{
    			if(height[l]<lmax)
    				vol+=lmax-height[l];
    			else 
    				lmax=height[l];
    			l++;
    		}
    		else 
    		{
    			if(rmax>height[r])
    				vol+=rmax-height[r];
    			else 
    				rmax=height[r];
    			r--;
    		}
    	}
    	return vol;
    }
    public static void main(String[] args) {
    	lc42 obj = new lc42();
    	int res = obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    	System.out.println(res);
    }
}