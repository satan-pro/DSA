import java.util.*;
class gfg1
{
	public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        int max=0;
        int left=0;
        int right =0;
        int sum=A[0];
        while(right<N)
        {
	        if(left<=right && sum>K)
	        {
	        	sum-=A[left];
	        	left++;
	        }
	        if(sum==K)
	        {
	        	max = Math.max(max,right-left+1);
	        }
	        right++;
	        if(right<N)
	        	sum+=A[right];
    	}
        return max;
    }
    public static void main(String[] args) {
    	int arr[] = {-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6};
    	int res = lenOfLongSubarr(arr,17,15);
    	System.out.println(res);
    }
}