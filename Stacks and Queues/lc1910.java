import java.util.*;
class lc1910  // Remove All Occurences of A Substring
{
	// More TC (Due to substring() method)
	public String removeOccurrences1(String s, String part) {
        StringBuilder res = new StringBuilder();
        int partLen = part.length();

        for(char c: s.toCharArray())
        {
        	// append each character to the StringBuilder
        	res.append(c);

        	// if res length > part and its last part contains the substring, then delete it
        	if(res.length()>=partLen && res.substring(res.length()-partLen).equals(part))
        		res.delete(res.length()-partLen, res.length());
        }

        return res.toString();
    }

    // Less TC (Using indexOf() method instead of substring())
    public String removeOccurrences(String s, String part) {
    	// Convert the entire string into a StringBuilder
        StringBuilder res = new StringBuilder(s);

        // If res contains part (Find this using the indexOf() method)
        while(res.indexOf(part)!=-1)
        {
        	int ind = res.indexOf(part);
        	// Delete the substring from the StringBuilder
        	res.delete(ind, ind+part.length());
        }

        return res.toString();
    }
}