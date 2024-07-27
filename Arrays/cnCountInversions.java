import java.util.*;
class cnCountInversions
{
	 public static long getInversions(long arr[], int n) {
        // Write your code here.
        int count=0;
        HashMap<String, Long> map = new HashMap<>();
        for(int i=arr.length-1; i>=0; i--)
        {
        	map.put(Long.toString(i), arr[i]);
        	for(Map.Entry<String, Long> mapElem:map.entrySet())
        		if(arr[i]>mapElem.getValue())
        			count++;
        }
        return count;   
    }
}