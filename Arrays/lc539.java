import java.util.*;
class lc539
{
	public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for(int i=0; i<minutes.length; i++)
        {
        	String time = timePoints.get(i);
        	int h = Integer.parseInt(time.substring(0,2));
        	int m = Integer.parseInt(time.substring(3));
        	minutes[i] = h*60+m;
        }

        Arrays.sort(minutes);

        int ans=Integer.MAX_VALUE;
        for(int i=1; i<minutes.length; i++)
        {
        	ans = Math.min(ans, Math.abs(minutes[i]-minutes[i-1]));
        }

        ans = Math.min(ans,24*60+minutes[0]-minutes[minutes.length-1]);
        return ans;
    }
}