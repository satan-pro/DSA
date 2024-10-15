import java.util.*;
class lc632
{
	public boolean isValid(int a, int b, int c, int d) {
		if(b-a<d-c)
			return true;
		else if(b-a == d-c)
		{
			if(a<c)
				return true;
		}
		return false;
	}
	public int[] smallestRange(List<List<Integer>> nums) {
        
        List<int[]> arr = new ArrayList<>();
        for(int i=0; i<nums.size(); i++)
        {
        	for(int j=0; j<nums.get(i).size(); j++)
        	{
        		arr.add(new int[]{nums.get(i).get(j), i});
        	}
        }

        arr.sort(Comparator.comparingInt(x->x[0]));

        int i=0,j=0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int x=-10000,y=10000;

        while(j<arr.size())
        {
        	int num = arr.get(j)[0];
        	int list = arr.get(j)[1];

        	map.put(list, map.getOrDefault(list, 0)+1);

        	while(map.size()>=nums.size())
        	{
        		if(isValid(arr.get(i)[0], arr.get(j)[0], x, y))
        		{
        			x=arr.get(i)[0];
        			y=arr.get(j)[0];
        		}

        		int leftList = arr.get(i)[1];
        		map.put(leftList, map.get(leftList)-1);
        		if(map.get(leftList)==0)
        			map.remove(leftList);

        		i++;
        	}
        	j++;
        }

        return new int[]{x,y};
    }
}