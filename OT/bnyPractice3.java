import java.util.*;
class bnyPractice3
{
	// Recursive Code : Not optimal not correct - O(2^n)
	int findMex(ArrayList<Integer> arr, int l, int r)
	{
		if(arr.size()==0)
			return 0;
		int start=0;
		int end = arr.get(arr.size()-1);
		int mex;
		for(int i=0; i<=arr.size(); i++)
		{
			if(arr.get(i)!=start)
			{
				mex=start;
				break;
			}
			start++;
		}
		mex = end+1;
		if(mex>=l && mex<=r)
			return 1;
		return 0;
	}
	void findSubsequence(int ind, int n, int l, int r, int[] arr, ArrayList<Integer> temp, ArrayList<Integer> mex)
	{
		if(ind>=n)
			return;

		int m = findMex(temp, l, r);
		mex.add(m);
		temp.add(arr[ind]);
		findSubsequence(ind+1, n, l, r, arr, temp, mex);
		temp.remove(temp.size()-1);
		findSubsequence(ind+1, n, l, r, arr, temp, mex);
	}
	int countSubsequences(int[] arr, int l, int r) {
		ArrayList<Integer> ans = new ArrayList<>();

		findSubsequence(0, arr.length, l, r, arr, new ArrayList<>(), ans);

		int sum=0;
		for(Integer i : ans)
			sum+=i;
		return sum;
	}

	// Correct code : Optimal + Full Output O(n*r)
	private static final int MOD = 1_000_000_007;
    private long[][] memo;
    private int[] arr;
    private int n, r;
    private Set<Integer>[] seen;

	public int countSubsequences(int[] arr, int l, int r) {
        this.arr = arr;
        this.n = arr.length;
        this.r = r;
        this.memo = new long[n + 1][r + 2];
        this.seen = new Set[n + 1];
        
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        for (int i = 0; i <= n; i++) {
            seen[i] = new HashSet<>();
        }

        long result = 0;
        for (int mex = l; mex <= r; mex++) {
            result = (result + dp(n, mex)) % MOD;
        }

        return (int) result;
    }

    private long dp(int i, int mex) {
        if (i == 0) {
            return mex == 0 ? 1 : 0;
        }
        
        if (mex > r + 1) {
            return 0;
        }
        
        if (memo[i][mex] != -1) {
            return memo[i][mex];
        }

        seen[i].addAll(seen[i-1]);
        seen[i].add(arr[i-1]);

        long result = dp(i - 1, mex);
        
        if (arr[i-1] < mex && seen[i].contains(mex - 1)) {
            result = (result - dp(i - 1, mex - 1) + MOD) % MOD;
        }

        memo[i][mex] = result;
        return result;
    }
}