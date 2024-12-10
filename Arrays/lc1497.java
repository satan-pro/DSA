import java.util.*;
class lc1497
{
	// Brute Force Approach - O(n^2)
	public boolean canArrange1(int[] arr, int k) {
        
        Arrays.sort(arr);
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int n: arr)
        	freq.put(n, freq.getOrDefault(n, 0)+1);

        for(int i=0; i<arr.length; i++)
        {
        	if(freq.get(arr[i])==0)
        		continue;

        	inner: for(int j=i+1; j<arr.length; j++)
        	{
        		if(freq.get(arr[j])==0)
        			continue;
        		if((arr[i]+arr[j])%k==0)
        		{
        			freq.put(arr[i], freq.get(arr[i])-1);
        			freq.put(arr[j], freq.get(arr[j])-1);
        			break inner;
        		}
        	}
        }

        boolean valid=true;
        for(Map.Entry<Integer, Integer> elem: freq.entrySet())
        {
        	if(elem.getValue()>0)
        		valid=false;
        }

        return valid;
    }

    // Optimal Approach
    public boolean canArrange(int[] arr, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n: arr)
        {
        	int rem = ((n%k)+k)%k;
        	map.put(rem, map.getOrDefault(rem, 0)+1);
        }

        for(Map.Entry<Integer, Integer> elem: map.entrySet())
        {
        	int rem = elem.getKey();
        	int count = elem.getValue();

        	if(rem==0)
        	{
        		if(count%2!=0)
        			return false;
        	}
        	else 
        	{
        		int halfRemCount = map.getOrDefault(k-rem, 0);
        		if(count!=halfRemCount)
        			return false;
        	}
        }
        return true;
    }
}