import java.util.*;
class lc3223
{
	// Brute Force Solution
	public int minimumLength1(String s) {
        int len = s.length();
        char arr[] = s.toCharArray();
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0; i<arr.length; i++)
        {
        	map.putIfAbsent(arr[i], new ArrayList<>());
        	map.get(arr[i]).add(i);
        }

        for(int i=1; i<arr.length; i++)
        {
        	if(arr[i]!='$')
        	{
        		char ch = arr[i];
        		ArrayList<Integer> temp = map.get(ch);
        		int j;
        		boolean found = false;

        		for(j=1; j<temp.size()-1; j++)
        		{
        			if(temp.get(j)==i)
        			{
        				found = true;
        				break;
        			}
        		}

        		if(found)
        		{
        			arr[temp.get(j+1)] = '$';
        			temp.remove(j+1);
        			temp.remove(j-1);
        			len-=2;
        		}
        	}
        }

        return len;
    }

    // Optimized Solution
    public int minimumLength(String s) {
        int freq[] = new int[26];
        char arr[] = s.toCharArray();

        // Building the frequency array
        for(char ch: arr)
        	freq[ch-'a']++;

        int len = 0;

        for(int i=0; i<26; i++)
        {
        	// If character doesnt exist continue
        	if(freq[i]==0)
        		continue;
        	// If character count is even, then at max 2 characters will remain
        	else if(freq[i]%2==0)
        		len+=2;
        	// If character count is even, then at max 1 character will remain
        	else
        		len+=1;
        }

        return len;
    }
}