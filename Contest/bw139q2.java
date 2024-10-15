import java.util.*;
class bw139q2
{
    class Pair
    {
        int x;
        int y;
        int health;
        public Pair(int a, int b, int h) {
            x=a;
            y=b;
            health=h;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,health-grid.get(0).get(0)));
        boolean vis[][][] = new boolean[m][n][health+1];

        int directions[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        boolean res = false;

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int currHealth = p.health;
            
            if(x==m-1 && y==n-1 && currHealth>=1)
                return true;

            for(int i=0; i<directions.length; i++)
            {
                int newX = x+directions[i][0];
                int newY = y+directions[i][1];
                if(newX>=0 && newX<m && newY>=0 && newY<n)
                {
                    int newHealth = currHealth-grid.get(newX).get(newY);
                
                    if(newHealth>=1 && !vis[newX][newY][newHealth])
                    {
                        q.offer(new Pair(newX, newY, newHealth));
                        vis[newX][newY][newHealth] = true;
                    }
                }
            }
        }
        return res;
    }}