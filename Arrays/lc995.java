import java.util.*;
class lc995
{
	public int minKBitFlips(int[] nums, int k) {
        
        int count=0;
        int flipCount=0;
        int flag[] = new int[nums.length];

        for(int i=0; i<nums.length; i++)
        {	
  			if(i>=k)
  				flipCount-=flag[i-k];

        	if((nums[i]+flipCount)%2==0)
        	{
        		if(i+k>nums.length)
        			return -1;
        		flipCount++;
        		count++;
        		if(i+k<nums.length)
        			flag[i]=1;
        	}
        }
        return count;
    }

    public static void main(String[] args) {
    	lc995 obj = new lc995();
    	int arr[] = {0,0,0,1,0,};
    	int k=1;
    	int res = obj.minKBitFlips(arr,k);
    	System.out.println(res);
    }
}