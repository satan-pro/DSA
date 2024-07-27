import java.util.*;
class lc3 // Longest Substring without Repeating Characters
{
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0, j=0;
        int maxCount=0;
        for(;j<s.length(); j++)
        {
            while(i<j && set.contains(s.charAt(j))) // Sliding Window until set does not contain duplicate
            {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxCount = Math.max(maxCount, j-i+1);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        lc3 obj = new lc3();
        int res = obj.lengthOfLongestSubstring("abba");
        System.out.println(res);
    }
}