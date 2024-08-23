import java.util.*;
class lc127
{
	// DFS Method
	int dfs(String word, String endWord, HashMap<String, Boolean> vis, List<String> wordList, ArrayList<ArrayList<Character>> dict)
	{
		vis.replace(word, true);

		if(word.equals(endWord))
			return 1;

		int min = Integer.MAX_VALUE;
		for(int i=0; i<dict.size(); i++)
		{
			for(char ch : dict.get(i))
			{
				char wordArr[] = word.toCharArray();
				wordArr[i] = ch;
				String newWord = new String(wordArr);

				if(wordList.contains(newWord) && !vis.get(newWord))
				{
					int steps = dfs(newWord, endWord, vis, wordList, dict);
					if(steps!=(int)(Math.pow(10, 8)))
					{
						min = Math.min(min, 1+steps);
					}
				} 
			}
		}
		vis.replace(word, false);
		return min==Integer.MAX_VALUE?(int)Math.pow(10, 8):min;
	}
	public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Boolean> vis = new HashMap<>();
        ArrayList<ArrayList<Character>> dict = new ArrayList<>();

        if(!wordList.contains(endWord))
        	return 0;

        for(int i=0; i<beginWord.length(); i++)
        	dict.add(new ArrayList<>());

        for(String s : wordList)
        {
        	vis.put(s, false);
        	for(int i=0; i<s.length(); i++)
        		dict.get(i).add(s.charAt(i));
        }

        vis.put(beginWord, false);

        int res = dfs(beginWord, endWord, vis, wordList, dict);
        if(res>=(int)(Math.pow(10, 8)))
            return 0;
        return res;
    }

    // BFS Traversal
    class Pair
    {
    	String word;
    	int steps;

    	public Pair(String s, int n)
    	{
    		word = s;
    		steps = n;
    	}
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	Queue<Pair> q = new LinkedList<>();
    	Set<String> set = new HashSet<>();

    	for(int i=0; i<wordList.size(); i++)
    	{
            set.add(wordList.get(i));
        }

        if(!set.contains(endWord))
            return 0;

    	q.offer(new Pair(beginWord, 1));

    	while(!q.isEmpty())
    	{
    		Pair curr = q.poll();
    		String currWord = curr.word;

    		if(currWord.equals(endWord))
    			return curr.steps;

    		for(int i=0; i<currWord.length(); i++)
    		{
    			for(char ch='a'; ch<='z'; ch++)
    			{
    				char wordArr[] = currWord.toCharArray();
    				wordArr[i] = ch;
    				String newWord = new String(wordArr);

    				if(set.contains(newWord))
                    {
    					q.offer(new Pair(newWord, curr.steps+1));
                        set.remove(newWord);
                    }
    			}
    		}
    	}
    	return 0;
    }
}