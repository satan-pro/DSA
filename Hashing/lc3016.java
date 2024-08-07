import java.util.*;
class lc3016  // Minimum Number of Pushes to Type Word II
{
	public int minimumPushes(String word) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        for(int i=0; i<word.length(); i++)
        {
        	map.put(word.charAt(i), map.getOrDefault(word.charAt(i),0)+1);
        } 

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        HashMap<Integer, Integer> nums = new HashMap<>();
        int curr=2;
        int total=0;
        for(Integer i: list)
        {
        	nums.put(curr, nums.getOrDefault(curr,0)+1);
        	total+=i*nums.get(curr);
        	curr++;
        	if(curr>9)
        		curr=2;
        }
        return total;
    }
}