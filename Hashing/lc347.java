import java.util.*;
class lc347  // Top K Frequent Elements
{
	public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store the frequency of all elements in a HashMap
        for(int i=0; i<nums.length; i++)
        {
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }	

        // Convert the HashMap to a List
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // Sort the list in descending order of values
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        int j=0;
        int res[] = new int[k];

        // Find only the top k elements in the sorted list
        for(Map.Entry<Integer, Integer> elem : list)
        {
        	if(j==k)
        		break;
        	res[j] = elem.getKey();
        	j++;
        }
       return res;
    }
    public static void main(String[] args) {
    	lc347 obj = new lc347();
    	int arr[] = {1,2};
    	int res[] = obj.topKFrequent(arr, 2);
    }
}