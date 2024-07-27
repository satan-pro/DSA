import java.util.*;
class lc60
{
	void permute(int k, int target, int arr[], StringBuilder ds, ArrayList<String> ans, boolean fmap[])
	{
		if(k==target)
			return;
		if(ds.length()==arr.length)
		{
			ans.add(ds.toString());
			k++;
			return;
		}
		for(int i=0; i<arr.length; i++)
		{
			if(!fmap[i])
			{
				fmap[i]=true;
				ds.append(arr[i]);
				permute(k,target,arr,ds,ans,fmap);
				ds.deleteCharAt(ds.length()-1);
				fmap[i]=false;
			}
		}
	}
	public String getPermutation(int n, int k) {
        int arr[] = new int[n];
        boolean fmap[] = new boolean[n];
        for(int i=0; i<n; i++)
        {
        	arr[i]=i+1;
        	fmap[i]=false;
        }
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder ds = new StringBuilder();
        permute(1,k,arr,ds,ans,fmap);
        return ans.get(k-1);
    }

    public static void main(String[] args) {
    	lc60 obj = new lc60();
    	int n=3;
    	int k=3;
    	String st = obj.getPermutation(3,3);
    	System.out.println(st);
    }
}