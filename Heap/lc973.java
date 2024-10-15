import java.util.*;
class lc973
{
	class Pair
	{
		int coord[];
		double dist;
		public Pair(int arr[], double k) {
			coord=arr;
			dist=k;
		}
	}
	public double findDistance(int x, int y) {
		return Math.sqrt((x*x)+(y*y));
	} 
	public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(o->o.dist));

        for(int i=0; i<points.length; i++)
        {
        	int x = points[i][0];
        	int y = points[i][1];
        	double d = findDistance(x,y);
        	pq.offer(new Pair(new int[]{x,y}, d));
        }

        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++)
        {
        	Pair p = pq.poll();
        	ans[i][0] = p.coord[0];
        	ans[i][1] = p.coord[1];
        }
        return ans;
    }
}