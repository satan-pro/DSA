import java.util.*;
class netcore2
{
	public static int solve(int n, String s, String t) {
    // Create a frequency map for the characters in s and t
    int[] sFreq = new int[26];
    int[] tFreq = new int[26];

    for (int i = 0; i < n; i++) {
        sFreq[s.charAt(i) - 'a']++;
        tFreq[t.charAt(i) - 'a']++;
    }

    // Check if the frequency of each character is the same in s and t
    for (int i = 0; i < 26; i++) {
        if (sFreq[i] != tFreq[i]) {
            return 0;
        }
    }

    // Check if the strings are already equal
    if (s.equals(t)) {
        return 1;
    }

    // Traverse the strings and check if any character can be swapped
    for (int i = 0; i < n; i++) {
        if (s.charAt(i) != t.charAt(i)) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == t.charAt(i) && t.charAt(j) == s.charAt(i)) {
                    return 1;
                }
            }
        }
    }

    // No valid swap found
    return 0;
}

    public static void main(String[] args) {
       int res = solve(4, "abcd", "abcs");
       System.out.println(res);
    }
}