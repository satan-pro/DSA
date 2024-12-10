import java.util.*;
class lc1593
{
	int maxLen = 0;
	public void getSubstring(int i, String s, HashSet<String> list) {
		if(i>=s.length())
		{
			maxLen = Math.max(maxLen, list.size());
			return;
		}

		for(int j=i+1; j<=s.length(); j++)
		{
			String sub = s.substring(i, j);

			if(!list.contains(sub))
			{
				list.add(sub);
				getSubstring(j, s, list);
				list.remove(sub);
			}
		}
	}
	public int maxUniqueSplit(String s) {
        HashSet<String> list = new HashSet<>();

        getSubstring(0, s, list);

        return maxLen;
    }
}