import java.util.*;
class lc30
{
	// Intuition: Slide through the entire string and find the possible substrings
	// Procedure: Create a dictionary for storing each element in the words[] array and their count
	// While sliding the string use a window map and store the word that is found and its respective count
	// If a word found in the input string is present in the dictionary only then you should consider to add that to the window
	// If the count of the words in the window is greater than that in the dictionary then remove the words from the left of the string and decrease their respective count in the window map
	// For each operation of adding and removing words increase/decrease the total count of words in the window
	// If the count of words in the window is equal to the no of words in the words[] array, then add the index to the ans 
	// If the word encountered is not present in the dictionary then clear the window and make i=j, and count=0
	// NOTE : You have to iterate through the no of charcters in the words[0] to find the starting point for the sliding window substring

	public List<Integer> findSubstring(String s, String[] words) {
       List<Integer> ans = new ArrayList<>();
       if(s==null || s.length()==0 || words.length==0)
       		return ans;

       	HashMap<String, Integer> dict = new HashMap<>();

       	for(String w:words)
       	{
       		dict.put(w, dict.getOrDefault(w, 0)+1);
       	}

       	int wordLen = words[0].length();
       	if(s.length()<(wordLen*words.length))
       		return ans;

       	// Iterate over the no of characters in each word for handling edge cases where there are unneccessary characters in the input string
       	for(int k=0; k<wordLen; k++)
       	{
       		HashMap<String, Integer> window = new HashMap<>();
       		int i,j;
       		i=j=k;
       		int count=0;
	       	while(j+wordLen<=s.length())
	       	{
	       		String word = s.substring(j, j+wordLen);
	       		j+=wordLen;

	       		if(dict.containsKey(word))
	       		{
	       			window.put(word, window.getOrDefault(word, 0)+1);
	       			count++;

	       			while(window.get(word)>dict.get(word))
	       			{
	       				String leftWord = s.substring(i, i+wordLen);
	       				window.put(leftWord, window.get(leftWord)-1);
	       				i+=wordLen;
	       				count--;
	       			}
	       			if(count==words.length)
	       				ans.add(i);
	       		}
	       		else 
	       		{
	       			window.clear();
	       			i=j;
	       			count=0;
	       		}
	       	}
        }
       	return ans;
    }
    public static void main(String[] args) {
    	String s = "barfoothefoobarman";
    	String words[] = {"foo","bar"};

    	lc30 obj = new lc30();
    	List<Integer> ans = obj.findSubstring(s, words);

    	for(Integer i:ans)
    		System.out.print(i+" ");
    }

}