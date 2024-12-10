import java.util.*;
class lc2490
{
	public boolean isCircularSentence(String sentence) {
        
        char chFirst = sentence.charAt(0);

        String arr[] = sentence.split(" ");

        char lastChar='c';
        for(int i=0; i<arr.length; i++)
        {
        	if(i>0 && lastChar!=arr[i].charAt(0))
        	{
        		return false;
        	}
        	lastChar = arr[i].charAt(arr[i].length()-1);
        }

        return lastChar==chFirst?true:false;
    }
}