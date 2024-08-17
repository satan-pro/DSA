import java.util.*;
class lc76  // Minimum Window Substring
{
	boolean isValid(HashMap<Character, Integer> map, HashMap<Character, Integer> dict)
	{
		for(Map.Entry<Character, Integer> elem : dict.entrySet())
		{
			if(!map.containsKey(elem.getKey()))
				return false;
			if(map.get(elem.getKey())<elem.getValue())
				return false;
		}
		return true;
	}
	public String minWindow(String s, String t) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for(int i=0; i<t.length(); i++)
        	dict.put(t.charAt(i), dict.getOrDefault(t.charAt(i), 0)+1);

        HashMap<Character, Integer> map = new HashMap<>();
        int i,j;
        i=j=0;
        String res="";
        int minLen = Integer.MAX_VALUE;
        while(j<s.length())
        {
        	map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);

        	while(isValid(map, dict))
        	{
        		if(j-i+1<minLen)
        		{
        			res=s.substring(i, j+1);
        			minLen = j-i+1;
        		}
        		map.replace(s.charAt(i), map.get(s.charAt(i))-1);
        		if(map.get(s.charAt(i))==0)
        			map.remove(s.charAt(i));
        		i++;
        	}
        	j++;
        }
        return res;
    }
}