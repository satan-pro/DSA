import java.util.*;
class lc3163
{
	// Sliding Window Method
	public String compressedString1(String word) {
        String comp="";

        if(word.length()==0)
        	return comp;

        int i=0, j=0;
        while(j<word.length())
        {
        	if(word.charAt(i)==word.charAt(j) && j-i+1>9)
        	{
        		comp = comp+(j-i+1)+word.charAt(j);
        		i=j;
        	}
        	if(word.charAt(i)!=word.charAt(j))
        	{
        		comp = comp+(j-i)+word.charAt(i);
        		i=j;
        	}
        	j++;
        }

        return comp;
    }

    // Intuitive Method
    public String compressedString(String word) {
        String comp="";

        if(word.length()==0)
        	return comp;

        int i=0;
        while(i<word.length())
        {
        	int count=0;
        	char ch = word.charAt(i);

        	inner: while(i<word.length() && word.charAt(i)==ch)
        	{
        		i++;
        		count++;
        		if(count==9)
        			break inner;
        	}
        	comp = comp + count + ch;
        }

        return comp;
    }
}