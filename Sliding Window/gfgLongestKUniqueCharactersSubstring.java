import java.util.*;
class gfgLongestKUniqueCharactersSubstring  // Longest K Unique Character Substring
{
	// Intuition : Create a HashMap to store each unique character and store the count of each character
	// Expand the window when the unique character count <= k
	// Compare the max size if the count == k
	// Shrink the window and decrease the count of the current character at 'i' when count > k
	int isValid(HashMap<Character, Integer> map)
	{
		int count=0;
		for(Map.Entry<Character, Integer> elem : map.entrySet())
		{
			if(elem.getValue()>0)
				count++;
		}
		return count;
	}
	public int longestkSubstr(String s, int k) {
        // code here
        int i,j;
        i=j=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max=-1;
        while(j<s.length())
        {
        	map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);

        	while(isValid(map)>k)
        	{
        		map.replace(s.charAt(i), map.get(s.charAt(i))-1);
        		// Remove the specific character if its count becomes 0
        		if(map.get(s.charAt(i))==0)
        			map.remove(s.charAt(i));
        		i++;
        	}

        	if(isValid(map)==k)
        		max = Math.max(max, j-i+1);
        	j++;
        }
        return max;
    }
}