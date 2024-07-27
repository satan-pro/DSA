import java.util.*;
class lc945
{
	 public int minIncrementForUnique(int[] nums) {
        
        Arrays.sort(nums);
        int moves = 0;

        boolean flag=false;
        while(!flag)
        { 
         	int count = 0;
        	for(int i=0; i<nums.length-1; i++)
        	{
        		int key = nums[i];
        		int j=i+1;
        		int c=0;
        		while(j<nums.length && nums[j]==key)
        		{
        			j++;
        			c++;
        		}
        		if(c>0)
        		{
        			nums[j-1]++;
        			count++;
        			moves++;
        		}
        	}
        	if(count==0)
        		flag=true;
        }

        return moves;
    }
    public static void main(String[] args) {
    	int nums [] = {3,2,1,2,1,7};
    	lc945 obj = new lc945();
    	int res = obj.minIncrementForUnique(nums);
    	System.out.println(res);
    }
}