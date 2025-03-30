import java.util.*;
class lc126
{
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        q.offer(list);

        ArrayList<String> levelWords = new ArrayList<>();
        levelWords.add(beginWord);
        int level = 0;

        Set<String> set = new HashSet<>();
        for(String w: wordList)
        	set.add(w);

        List<List<String>> ans = new ArrayList<>();

        while(!q.isEmpty())
        {
        	ArrayList<String> currList = q.poll();

        	if(currList.size()>level)
        	{
        		level++;
        		for(String w: levelWords)
        			set.remove(w);
        	}

        	String word = currList.get(currList.size()-1);

        	if(word.equals(endWord))
        	{
        		if(ans.size()==0)
        			ans.add(currList);
        		else if(currList.size()==ans.get(0).size())
        			ans.add(currList);
        	}

        	for(int i=0; i<word.length(); i++)
        	{
        		for(char ch='a'; ch<='z'; ch++)
        		{
        			char wordArr[] = word.toCharArray();
        			wordArr[i] = ch;
        			String newWord = new String(wordArr);

        			if(set.contains(newWord))
        			{
        				currList.add(newWord);

        				ArrayList<String> temp = new ArrayList<>(currList);
        				q.offer(temp);

        				levelWords.add(newWord);
        				currList.remove(currList.size()-1);
        			}
        		}
        	}
        }

        return ans;
    }
}