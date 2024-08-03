import java.util.*;
class uber3
{
	public int characterReplacementVariation(String s, int k)
    {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++)
        {
            if(!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
        }

        int maxCount=0;
        for(Character ch: set)
        {
            char c = ch;
            int i=0, j=0, freq=0;
            while(j<s.length())
            {
                if(s.charAt(j)!=c)
                    freq++;

                while(freq>k)
                {
                    if(s.charAt(i)!=c)
                        freq--;
                    i++;
                }

                maxCount = Math.max(maxCount, j-i+1);
                j++;
            }
        }
        return maxCount;
    }
}