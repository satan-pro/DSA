import java.util.*;
class lc502
{
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i=0; i<profits.length; i++)
        {
        	ArrayList<Integer> val = new ArrayList<>();
        	val.add(profits[i]);
        	val.add(capital[i]);
        	arr.add(val);
        }

        Collections.sort(arr, new Comparator<ArrayList<Integer>>(){
        	@Override
        	public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2)
        	{
        		return l2.get(0).compareTo(l1.get(0));
        	}
        });

        int count=0;
        boolean updated;

        while(count<k)
        {
        	updated=false;
        	for(int i=0; i<arr.size(); i++)
        	{
        		if(arr.get(i).get(1)<=w)
        		{
        			w+=arr.get(i).get(0);
        			arr.remove(i);
        			count++;
        			updated=true;
        			break;
        		}
        	}
        	if(!updated){
        		break;
        	}
        }
        return w;
    }
    public static void main(String[] args) {
    	int k=3;
    	int w=0;
    	int profits[] = {1,2,3};
    	int capital[] = {0,1,2};

    	lc502 obj = new lc502();
    	int res = obj.findMaximizedCapital(k,w,profits,capital);
    	System.out.println(res);
    }
}