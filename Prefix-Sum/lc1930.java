import java.util.*;
class lc1930  // Unique Length-3 Palindromic Subsequence
{
	public int countPalindromicSubsequence(String s) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        // Storing all the characters in the string in a HahshMap
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(!map.containsKey(ch))
            {
                map.put(ch, new ArrayList<>());
                map.get(ch).add(i);
            }
            else if(map.containsKey(ch))
            {
                if(map.get(ch).size()==2)
                {
                    map.get(ch).set(1,i);
                }
                else 
                    map.get(ch).add(i);
            }
        }

        // Now finding the no of palindromes
        // Example: aba, aca, ada, aaa
        // To find the palindromes with length 3, we just need to find the no of unique chaarcters occuring at the position 1
        // Store the middle characters in the palindrome in a Set
        // finally add the size of the Set to the count
        int count = 0;
        for(Map.Entry<Character, ArrayList<Integer>> elem: map.entrySet())
        {
            if(elem.getValue().size()<2)
                continue;
            
            int start = elem.getValue().get(0);
            int end = elem.getValue().get(1);
            Set<Character> set = new HashSet<>();

            for(int i=start+1; i<end; i++)
            {
                set.add(s.charAt(i));
            }
            count+=set.size();
        }

        return count;
    }
}