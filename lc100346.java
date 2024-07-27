import java.util.*;
class lc100346
{
	/*public int minOperations(int[] nums) {
        int count=0;
        boolean flag=false;
        int k=0;
        for(int i=0; i<nums.length;)
        {
        	int j=i;
        	if(nums[i]==0 && i<nums.length-1)
        	{
        		nums[i]=1;
        		flag=true;
        	}
        	else if(flag && nums[i]==1)
        	{
        		k=i;
        		for(;j<nums.length;j++)
        		{
        			nums[j]=nums[j]==0?1:0;
        		}
        	}
        	if(i>=nums.length || j>=nums.length)
        	{
        		count++;
        		i=k;
        		continue;
        	}
        	i++;
        }
        if(nums[nums.length-1]==0)
            return count+1;
        return count;
    }*/

    public int minOperations(int[] nums) {
    int count = 0;
    boolean flipped = false;

    for (int i = 0; i < nums.length; i++) {
        
        int currentValue = flipped ? 1 - nums[i] : nums[i];
        
        if (currentValue == 0) {
            
            count++;
            flipped = !flipped;
        }
    }

    return count;
}

    public static void main(String[] args) {
    	int arr[] = {1,0,1,0,1};
    	lc100346 obj = new lc100346();
    	int res = obj.minOperations(arr);
    	System.out.println(res);
    }
}