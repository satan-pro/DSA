import java.util.*;
class lc3288
{
	public int LIS(ArrayList<Integer> arr) {
		ArrayList<Integer> dp = new ArrayList<>();

		for(int i=0; i<arr.size(); i++)
		{
			int curr = arr.get(i);
			if(dp.size()==0 || curr>dp.get(dp.size()-1))
				dp.add(curr);
			else {
				int pos = Collections.binarySearch(dp, curr);
				if(pos<0)
					pos = Math.abs(pos)-1;
				dp.set(pos, curr);
			}
		}
		return dp.size();
	}
	public int maxPathLength(int[][] coordinates, int k) {
		
		int[] fixedPoint  = coordinates[k];

        Arrays.sort(coordinates, (a,b)->{
        	if(a[0]==b[0])
        		return b[1]-a[1];
        	return a[0]-b[0];
        });

       ArrayList<Integer> points1 = new ArrayList<>();
       ArrayList<Integer> points2 = new ArrayList<>();

       for(int i=0; i<coordinates.length; i++)
       {
       		int x = coordinates[i][0];
       		int y = coordinates[i][1];

       		if(x<fixedPoint[0] && y<fixedPoint[1])
       			points1.add(y);

       		if(x>fixedPoint[0] && y>fixedPoint[1])
       			points2.add(y);
       }

        int size1 = LIS(points1);
        int size2 = LIS(points2);

        return size1+size2+1;
    }
}