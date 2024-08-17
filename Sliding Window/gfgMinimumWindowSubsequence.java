import java.util.*;
class gfgMinimumWindowSubsequence
{
	static boolean isValid(HashMap<Character, Integer> map, HashMap<Character, Integer> dict)
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
	static boolean isSubsequence(String s, String t)
	{
		if(t.length()>s.length())
			return false;
		int j=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)==t.charAt(j))
				j++;
		}
		return (j==t.length())?true:false;

	}
	static String minWindow(String str1, String str2) {
        // code here
        HashMap<Character, Integer> dict = new HashMap<>();
        for(int i=0; i<str2.length(); i++)
        	dict.put(str2.charAt(i), dict.getOrDefault(str2.charAt(i), 0)+1);

        HashMap<Character, Integer> map = new HashMap<>();
        int i,j;
        i=j=0;
        int minLen = Integer.MAX_VALUE;
        String res = "";

        while(j<str1.length())
        {
        	map.put(str1.charAt(j), map.getOrDefault(str1.charAt(j), 0)+1);

        	while(isValid(map, dict))
        	{
        		if(isSubsequence(str1.substring(i, j+1), str2))
        		{
        			if(j-i+1<minLen)
        			{
        				res = str1.substring(i, j+1);
        				minLen = j-i+1;
        			}
        		}
        		map.replace(str1.charAt(i), map.get(str1.charAt(i))-1);
        		i++;
        	}
        	j++;
        }
        return res;
    }
}