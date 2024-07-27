import java.util.*;
class lc104 // Fruits into basket
{
	public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0, j=0, count=0, maxCount=0;
        while(j<fruits.length)
        {
        	if(!map.containsKey(fruits[j])) // Checking if the fruit already present
        	{
        		map.put(fruits[j], 1);
        		count++;
        	}
        	else
        	{
        		int fCount = map.get(fruits[j]); // Increasing fruit count in map and variable
        		map.replace(fruits[j], fCount+1);
        		count++;
        	}
        	if(map.size()>2) // Sliding window if fruit type > 2
        	{
        		count--;
        		int fCount = map.get(fruits[i]);
        		map.replace(fruits[i], fCount-1);
        		if(map.get(fruits[i])==0)
        			map.remove(fruits[i]);
        		i++;
        	}
        	if(map.size()<=2)
        		maxCount = Math.max(maxCount, count); // Calculate maxCount only if fruit type<=2
        	j++;
        }
        return maxCount;
    }
}