import java.util.*;
class gfgKthElementOfTwoArrays
{
	public long kthElement( int arr1[], int arr2[], int n, int m, int k) {

        if(n>m)
        	return kthElement(arr2, arr1, m, n, k);

        int low=Math.max(0, k-m), high = Math.min(k,n);

        while(low<=high)
        {
        	int mid1 = (low+high)/2;
        	int mid2 = k-mid1;

            System.out.println(mid1+" "+mid2);
        	int l1 = mid1>0?arr1[mid1-1]:Integer.MIN_VALUE;
        	int l2 = mid2>0?arr2[mid2-1]:Integer.MIN_VALUE;
        	int r1 = mid1<n?arr1[mid1+1]:Integer.MAX_VALUE;
        	int r2 = mid2<m?arr2[mid2+1]:Integer.MAX_VALUE;

        	if(l1<=r2 && l2<=r1)
        	{
        		return (long)Math.max(l1,l2);
        	}
        	else if(l1>r2)
        		high= mid1-1;
        	else  
        		low=mid1+1;
        }

        return -1;
        
    }

    public static void main(String[] args) {
    	int arr1[] = {4 ,5, 6, 6 ,13};
    	int arr2[] = {4 ,4 ,5, 6, 6, 7, 8, 9 ,9, 11, 12, 13 ,13};
    	gfgKthElementOfTwoArrays obj = new gfgKthElementOfTwoArrays();
    	long ans = obj.kthElement(arr1,arr2,5,13,9);
    	System.out.println(ans);
    }

}