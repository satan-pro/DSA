import java.util.*;
class lc2554
{
	// Solution 1: Linear Search on banned HashSet
    // TC: O(N)  SC: O(N)
	public int maxCount1(int[] banned, int n, int maxSum) {
        int count=0;
        int sum=0;
        HashSet<Integer> bannedSet = new HashSet<>();

        for(int i: banned)
        	bannedSet.add(i);

        int k=0;
        for(int i=1; i<=n; i++)
        {
        	if(bannedSet.contains(i))
        		continue;

        	if(sum+i>maxSum)
        		break;
        	sum+=i;
        	count++;
        }

        return count;
    }

    // Solution 2: Binary Search on banned array 
    // TC: O(NlogN) SC: O(1)
    public boolean searchBanned(int i, int[] banned) {
    	int low = 0;
    	int high = banned.length-1;

    	while(low<=high)
    	{
    		int mid = low+(high-low)/2;

    		if(banned[mid]==i)
    			return true;
    		else if(banned[mid]>i)
    			high = mid-1;
    		else 
    			low = mid+1;
    	}
    	return false;

    }
    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int sum=0;
        int count=0;

        for(int i=1; i<=n; i++)
        {
        	if(searchBanned(i, banned))
        		continue;

        	if(sum+i>maxSum)
        		return count;
        	sum+=i;
        	count++;
        }
        return count;
    }
}