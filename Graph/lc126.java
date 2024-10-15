import java.util.*;
class lc126
{
	class Pair
	{
		String word;
		int steps;
		ArrayList<String> list = new ArrayList<>();

		public Pair(String s, int n, ArrayList<String> ls)
		{
			word = s;
			steps = n;
			list = ls;
		}
	}
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for(String s : wordList)
        	set.add(s);

        List<List<String>> ans = new ArrayList<>();

        if(!set.contains(endWord))
        	return ans;

        Queue<Pair> q = new LinkedList<>();
        ArrayList<String> start = new ArrayList<>();
        start.add(beginWord);
        q.offer(new Pair(beginWord, 1, start));

        int minSteps = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();

        while(!q.isEmpty())
        {
        	int levelSize = q.size();
        	Set<String> levelWords = new HashSet<>();

        	for(int i=0; i<levelSize; i++)
        	{
	        	Pair curr = q.poll();
	        	String currWord = curr.word;
	        	ArrayList<String> currList = curr.list;

	        	if(currWord.equals(endWord) && curr.steps<=minSteps)
	        	{
	        		ans.add(new ArrayList<>(curr.list));
	        		minSteps = curr.steps;
	        	}

	        	for(int i=0; i<currWord.length(); i++)
	        	{
	        		char wordArr[] = currWord.toCharArray();
	        		for(char ch='a'; ch<='z'; ch++)
	        		{
	        			wordArr[i]=ch;
	        			String newWord = new String(wordArr);

	        			if(set.contains(newWord) && !visited.contains(newWord))
	        			{
	        				ArrayList<String> newList = new ArrayList<>(currList);
	        				newList.add(newWord);
	        				q.offer(new Pair(newWord, curr.steps+1, newList));
	        				levelWords.add(newWord);
	        			}
	        		}
	        	}
        	}
        	visited.addAll(levelWords);
        }
        return ans;
    }
}