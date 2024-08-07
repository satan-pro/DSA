import java.util.*;
class lc2053  // Kth Distinct String in an Array
{
	public String kthDistinct(String[] arr, int k)
	{
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++)
		{
			if(!map.containsKey(arr[i]))
				map.put(arr[i], i);
			else
				map.replace(arr[i], -1);
		}

		int target=0;
		for(String s: arr)
		{
			if(map.get(s)>=0)
				target++;
			if(target==k)
				return s;
		}
		return "";
	}
}