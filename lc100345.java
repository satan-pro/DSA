class lc100345
{
	public int minimumOperations(int[] nums) {
		int count=0;
        for(int i=0; i<nums.length; i++)
        {
        	if(nums[i]%3==0)
        		continue;
        	int rem = nums[i]%3;
        	if(rem==1)
        		nums[i]-=1;
        	else if(rem==2)
        		nums[i]+=1;
        	count++;
        }
        return count;
    }

    public static void main(String[] args) {
    	int arr[]={3,6,9};
    	lc100345 obj = new lc100345();
    	int res = obj.minimumOperations(arr);
    	System.out.println(res);
    }
}