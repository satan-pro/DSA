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
        q.offer(new Pair(beginWord, 1, new ArrayList<>()));

        int minSteps = Integer.MAX_VALUE;

        while(!q.isEmpty())
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
        		for(char ch='a'; ch<='z'; ch++)
        		{
        			char wordArr[] = currWord.toCharArray();
        			wordArr[i]=ch;
        			String newWord = new String(wordArr);

        			if(set.contains(newWord))
        			{
        				ArrayList<String> newList = new ArrayList<>(currList);
        				newList.add(newWord);
        				q.offer(new Pair(newWord, curr.steps+1, newList));
        				set.remove(newWord);
        			}
        		}
        	}
        }
        return ans;
    }
}