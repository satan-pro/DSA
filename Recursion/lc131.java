import java.util.*;
class lc131
{
	boolean checkPalindrome(String s, int start, int end)
	{
		while(start<=end)
		{
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	void func(int ind, int n, String s, List<List<String>> ans, List<String> ds)
	{
		if(ind>=n)
		{
			ans.add(new ArrayList(ds));
			return;
		}

		for(int i=ind; i<n; i++)
		{
			if(checkPalindrome(s,ind,i))
			{
				ds.add(s.substring(ind,i+1));
				func(i+1,n,s,ans,ds);
				ds.remove(ds.size()-1);
			}
		}
	}
	public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        func(0,n,s,ans,new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
    	lc131 obj = new lc131();
    	String s = "aabb";
    	List<List<String>> ans = obj.partition(s);
    	for(List<String> i : ans)
    	{
    		System.out.print("[ ");
    		for(String st : i)
    			System.out.print(st+", ");
    		System.out.print(" ], ");
    	}
    }
}