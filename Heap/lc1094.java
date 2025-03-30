import java.util.*;
class lc1094
{
	public boolean carPooling(int[][] trips, int capacity) {
		// Sort the array by location: (first by start time, if same then by end time)
        Arrays.sort(trips, (a,b)->{
            if(a[1]==b[1])
                return a[2]-b[2];
            return a[1]-b[1];
        });

        if(trips[0][0]>capacity)
            return false;

        capacity-=trips[0][0];

        // Create a PriorityQueue storing (numberOfPassengers, endTime) to sort by end time
        PriorityQueue<int[]> end = new PriorityQueue<>((a,b)->a[1]-b[1]);
        end.offer(new int[]{trips[0][0], trips[0][2]});

        for(int i=1; i<trips.length; i++)
        {
            while(!end.isEmpty() && end.peek()[1]<=trips[i][1])
            {
            	// Increase the capacity if the endTime is less than the current StartTime
                capacity+=end.poll()[0];
            }
            // If capacity permits do this
            if(capacity>=trips[i][0])
            {
                capacity-=trips[i][0];
                // Add the new pair to PriorityQueue
                end.offer(new int[]{trips[i][0],trips[i][2]});
            }
            // If capacity doesnt permit, return false
            else
                return false;
        }
        return true;
    }
}