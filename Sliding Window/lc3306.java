import java.util.*;
class lc3306
{	
	public boolean hasVowels(int[] freq) {
		char ch[] = {'a', 'e', 'i', 'o', 'u'};
	    
	    // Ensure all vowels are present at least once
	    for (char c : ch) {
	        if (freq[c - 'a'] <= 0)
	            return false;
	    }

	    return true;
	}

	public int countConsonants(int[] freq) {
		int count = 0;

		for (int i = 0; i < freq.length; i++) {
	        if (freq[i] > 0 && i != ('a' - 'a') && i != ('e' - 'a') && i != ('i' - 'a') && i != ('o' - 'a') && i != ('u' - 'a')) {
	            count+=freq[i];
	        }
	    }

	    return count;
	}

	public long countOfSubstrings(String word, int k) {
	    long count = 0;
	    int i = 0, j = 0;
	    int[] freq = new int[26];

	    while (j < word.length()) {
	        freq[word.charAt(j) - 'a']++;

	        while (countConsonants(freq)>k) {
	            freq[word.charAt(i) - 'a']--;
	            i++;
	        }

	        if (hasVowels(freq) && countConsonants(freq)==k) {
	            count++;
	        }

	        j++;
	    }
	    while (i < word.length()) {
            freq[word.charAt(i) - 'a']--;
            i++;
            if (hasVowels(freq) && countConsonants(freq) == k) {
                System.out.println(i+" "+j);
                count++;
            } else {
                // Once a window becomes invalid, further shrinking won't help.
                break;
            }
        }

	    return count;
	}

}