import java.util.*;
class lc567 // Permutation in a String
{
	// Intuition : To find if a permutation is contained in a string find the common ground for each permutation
	// Common ground for each permutation of a string is the frequencies of the characters in the string

	// Using HashMap
	public boolean checkInclusion1(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i=0; i<s1.length(); i++)
        {
        	map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        int i=0, j=0;

        while(j<s2.length()) // Sliding Window
        {
        	char ch = s2.charAt(j);
        	map2.put(ch, map2.getOrDefault(ch, 0)+1);

        	while((j-i+1)>s1.length())  // Shrink Window if the size of window is greater than s1.length()
        	{
        		map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)-1);
        		if(map2.get(s2.charAt(i))==0)
        			map2.remove(s2.charAt(i));
        		i++;
        	}

        	if(map1.equals(map2))
        		return true;

        	j++;
        }

        return map1.equals(map2);
    }

    // Using Arrays instead of HahsMap
	public boolean checkInclusion(String s1, String s2) {
		// Create two arrays of size 26 which stores the frequencies of each letter in the string
        int freq1[] = new int[26]; 
        int freq2[] = new int[26];

        for(int i=0; i<s1.length(); i++)
        {
        	freq1[s1.charAt(i)-'a']++;
        }

        int i=0, j=0;
        while(j<s2.length()) // Sliding window
        {
        	char ch = s2.charAt(j);
        	freq2[ch-'a']++;

        	if((j-i+1)>s1.length()) // Shrink Window if the size of window is greater than s1.length()
        	{
        		freq2[s2.charAt(i)-'a']--;
        		i++;
        	}

        	if(Arrays.equals(freq1, freq2))
        		return true;
        	j++;
        }
        return false;
    }

    public static void main(String[] args) {
    	String st = "eidbaooo";
    	String find = "ab";
    	lc567 obj = new lc567();
    	System.out.println(obj.checkInclusion(find, st));
    }
}