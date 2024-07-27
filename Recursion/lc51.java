import java.util.*;
class lc51
{
	boolean check(List<List<Integer>> mat, int n, int m)
	{
		for(int i=0; i<mat.size(); i++)
		{
			if(mat.get(i).get(0)==n || mat.get(i).get(1)==m)
				return false;
			if(mat.get(i).get(1)+1==m || mat.get(i).get(1)-1==m)
				return false;
		}
		List<Integer> temp = new ArrayList<>();
		temp.add(n);
		temp.add(m);
		mat.add(new ArrayList<>(temp));
		return true;
	}
	void generate(int ind, int n, List<String> ds, List<List<String>> ans, List<List<Integer>> mat){

		if(ind>=n)
		{
			ans.add(new ArrayList<>(ds));
			return;
		}
		for(int i=0; i<n; i++)
		{
			boolean flag = check(mat, ind, i);
			if(flag)
			{
				String sb = "....";
				String s = sb.substring(0,i)+"Q"+sb.substring(i+1);
				ds.add(s);
				System.out.println(ind);
				System.out.println(s);
				generate(ind+1, n, ds, ans, mat);
				ds.remove(ds.size()-1);
				mat.remove(mat.size()-1);
				generate(ind+1, n, ds, ans, mat);
			}
		}
	}

	 public List<List<String>> solveNQueens(int n) {
	 	List<List<String>> ans = new ArrayList<>();
	 	generate(0,n,new ArrayList<>(), ans, new ArrayList<>());
	 	return ans;
	}

	public static void main(String[] args) {
		lc51 obj = new lc51();
		int n=4;
		List<List<String>> ans = obj.solveNQueens(n);
		for(List<String> i : ans)
		{
			System.out.print("[");
			for(int j=0; j<i.size(); j++)
				System.out.print(i.get(j));
			System.out.print("],");
		}
	}
        
    
}