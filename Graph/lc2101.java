import java.util.*;
class lc2101
{
	public int dfs(int i, int[][] bombs, boolean[] vis) {
		vis[i] = true;
		int x = bombs[i][0];
		int y = bombs[i][1];
		int r = bombs[i][2];

		int count = 1;

		for(int j=0; i<bombs.length; j++)
		{
			if(i==j)
				continue;
			int h = bombs[j][0];
			int k = bombs[j][1];

			double dist = Math.pow((x-h), 2)+Math.pow((y-k), 2);
			if(dist<=Math.pow(r, 2) && !vis[j])
				count+=dfs(j, bombs, vis);
		}

		return count;
	}
	public int maximumDetonation(int[][] bombs) {
        boolean[] vis = new boolean[bombs.length];

        int ans = 0;
        for(int i=0; i<bombs.length; i++)
        {
       		Arrays.fill(vis, false);
       		ans = Math.max(ans, dfs(i, bombs, vis));
        }

        return ans;
    }
}