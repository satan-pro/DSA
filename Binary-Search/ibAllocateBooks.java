import java.util.*;
class ibAllocateBooks // Allocate Minimum Pages 
{
	boolean checkValid(int max, int b, int[] arr) // Method to find the no of students that can occupy no of pages
	{
		int count=1, sum=0;
		for(int i=0; i<arr.length; i++)
		{
			if(sum+arr[i]<=max)
				sum+=arr[i];
			else 
			{
				sum=arr[i];
				count++;
			}
			if(count>b)
				return false;
		}
		return (count>b)?false:true;
	}
	public int books(int[] A, int B) {

		if(B>A.length)
            return -1; // Return if students > books

		int sum=0;
		int arrMax=A[0];
		// Find the totalSum and max value of the array
		for(int i=0; i<A.length; i++) 
		{
			sum+=A[i];
			arrMax = Math.max(arrMax, A[i]);
		}

		int low=arrMax, high=sum;
		int min = high;
		int mid;

		// Start binary Search 
		while(low<=high)
		{
			mid=(low+high)/2;
			if(checkValid(mid, B, A)) 
			{
				// If no of students is lesser than equal to B then decrease high
				high = mid-1;
				min = Math.min(min, mid);
			}
			else 
				// If no of students is greater than B then increase low
				low = mid+1;
		}
		return min;
    }
}