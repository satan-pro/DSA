class gfgSubsetSum {
    void func(int ind, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> ans)
    {
        if(ind>=n)
        {
            ans.add(sum);
            return;
        }
        func(ind+1, sum+arr.get(ind), arr, n, ans);
        func(ind+1, sum, arr, n, ans);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        func(0,0,arr,n,ans);
        Collections.sort(ans);
        return ans;
    }
}