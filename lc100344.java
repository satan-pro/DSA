class lc100344
{
	public int minOperations(int[] nums) {
		
		int count=0;
        
     
        for(int i=0; i<nums.length; i++)
        {
        	
        	if(nums[i]==0)
        	{
                if((i+2)<nums.length)
                {
                    int j=0;
                    while(j<=2)
                    {
                        nums[i+j]=nums[i+j]==0?1:0;
                        j++;
                    }
                    count++;
                }
                else
                    return -1;
        	}
        	
        }
        
        return count;
    }

    public static void main(String[] args) {
    	int arr[] = {0,1,1,1};
    	lc100344 obj = new lc100344();
    	int res = obj.minOperations(arr);
    	System.out.println(res);
    }
}