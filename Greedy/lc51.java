import java.util.*;
class lc51
{
	boolean check(List<List<Integer>> mat, int n, int m)
	{
		for(int i=0; i<mat.size(); i++)
		{
			if(mat.get(i).get(0)==m || mat.get(i).get(1)==n)
				return false;
			if(mat.get(i).get(0)+1==m || mat.get(i).get(0)-1==m)
				return false;
		}
		List<Integer> temp = new ArrayList<>();
		temp.add(m);
		temp.add(n);
		mat.add(new ArrayList<>(temp));
		return true;
	}
	void generate(int ind, int n, List<String> ds, List<List<String>> ans, StringBuilder sb, List<List<Integer>> mat){

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
				sb.setCharAt(i,'Q');
				ds.add(sb.toString());
				generate(ind+1, n, ds, ans, new StringBuilder("...."), mat);
				ds.remove(ds.size()-1);
				mat.remove(mat.size()-1);
			}
		}
	}

	 public List<List<String>> solveNQueens(int n) {
	 	List<List<String>> ans = new ArrayList<>();
	 	generate(0,n,new ArrayList<>(), ans, new StringBuilder("...."), new ArrayList<>());
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