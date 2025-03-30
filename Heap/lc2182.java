import java.util.*;
class lc2182
{
	public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for(int i=0; i<s.length(); i++)
        {
        	int ch = (int)s.charAt(i);

        	map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        String res = "";

        boolean notBuilt=true;

        while(notBuilt)
        {
        	Map.Entry<Integer, Integer> elem = map.firstEntry();

        	if(elem.getValue()<=repeatLimit)
        	{
        		char c = (char)elem.getKey().intValue();
        		res = res+String.valueOf(c).repeat(elem.getValue());

        		map.remove(elem.getKey());
        	}
        	else 
        	{
        		char c = (char)elem.getKey().intValue();
        		res = res+String.valueOf(c).repeat(repeatLimit);

        		map.put(elem.getKey(), elem.getValue()-repeatLimit);

        		int i=0;
        		if(map.size()==1)
        			notBuilt=false;
        		else {
	        		outer: for(Map.Entry<Integer, Integer> nextElem: map.entrySet())
	        		{
	        			if(i==1)
	        			{
	        				char cNext = (char)nextElem.getKey().intValue();
	        				res = res+cNext;
	        				map.put(nextElem.getKey(), nextElem.getValue()-1);
	        				break outer;
	        			}
	        			i++;
	        		}
        		}
        	}
        }

        return res;

    }
}