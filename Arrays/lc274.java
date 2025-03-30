import java.util.*;
class lc274
{
	// helper function for binary search
	public int isValid(int[] citations, int mid) {
		int count=0;
		for(int n: citations)
		{
			if(n>=mid)
				count++;
		}
        
        // checking if minimum 'h' papers have been published && have citations >= 'h'
		if(citations.length>=count && count>=mid)
			return 1;
		return -1;
	}
	public int hIndex(int[] citations) {
        Arrays.sort(citations);

        // binary search ranging from [0, highest num in the array]
        int low = 0, high = citations[citations.length-1];

        int ans=1;
        while(low<=high)
        {
        	int mid = (low+high)/2;
        	int check = isValid(citations, mid);
            
            // find max 'h' value
        	if(check==1)
        	{
        		ans = mid;
        		low = mid+1;
        	}
        	else 
        		high = mid-1;
        }

        return ans;
    }
}