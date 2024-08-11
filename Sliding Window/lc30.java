import java.util.*;
class lc30
{
	boolean checkMap(HashMap<String, Integer> map)
	{
		for(Integer i : map.values())
		{
			if(i!=0)
				return false;
		}
		return true;
	}
	int findLeast(HashMap<String, Integer> store)
	{
		int min = Integer.MAX_VALUE;
		for(Integer i : store.values())
			min = Math.min(min, i);
		return min;
	}
	public List<Integer> findSubstring(String s, String[] words) {
        int w = words[0].length();
        int j,i, count;
        j=i=count=0;
        List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        Set<Character> charSet = new HashSet<>();
        for(String st: words)
        {
        	map.put(st, map.getOrDefault(st, 0)-1);
        	charSet.add(st.charAt(0));

        }
        while(j<s.length()-w)
        {
        	if(charSet.contains(s.charAt(j)))
        	{
        		String curr = s.substring(j, j+w);
        		if(map.containsKey(curr))
        		{
        			if(map.get(curr)>=0)
        			{
        				while(map.get(curr)>=0 || !map.contains(s.substring(i, i+w)))
        				{
        					if(map.containsKey(s.substring(i, i+w)))
        					{
        						String currShrink = s.substring(i, i+w);
        						map.replace(currShrink, map.get(currShrink)-1);
        						count--;
        					}
        					i+=w;
        				}
        			}
        			map.replace(curr, map.get(curr)+1);
        			count++;
        		}
        	}
        	for(Map.Entry<String, Integer> elem : map.entrySet())
        	{
        		System.out.println(elem.getKey()+" "+elem.getValue());
        	}
        	if(count==words.length)
        	{
        		if(!ans.contains(i))
        			ans.add(i);
        	}
        	j+=w;
        }
        return ans;
    }

}