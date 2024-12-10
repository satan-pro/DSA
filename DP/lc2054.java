import java.util.*;
class lc2054
{
	public int findMax(int i, int[][] events, int[] dp) {
		if(i>=events.length)
			return 0;
		if(dp[i]!=-1)
			return dp[i];

		int nextEvent = findBinarySearch(i, events);

		int pick = events[i][2];
		if(nextEvent!=-1)
			pick += findMax(nextEvent, events, dp);

		int notPick = findMax(i+1, events, dp);

		return dp[i] = Math.max(pick, notPick);
	}
	public int findBinarySearch(int index, int[][] events) {
		int low=0, high=events.length-1;
		while(low<=high)
		{
			int mid = (low+high)/2;
			if(events[mid][0]>events[index][1])
			{
				if(events[mid-1][0]>events[index][1])
					high=mid-1;
				else 
					return mid;
			}
			else 
				low=mid+1;
		}
		return -1;
	}
	public int maxTwoEvents1(int[][] events) {
		Arrays.sort(events, (a,b)->a[0]-b[0]);

        int dp[] = new int[events.length];
        Arrays.fill(dp, -1);

        int res = findMax(events.length-1, events, dp);
        return res;
    }

    public int maxTwoEvents(int[][] events) {
		// Sort the arrays by the start time
		Arrays.sort(events, (a,b)->a[0]-b[0]);
		// Create a priority queue to store the events, sorted by their end time
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		int maxVal=0, res=0;

		for(int[] arr: events)
		{
			// Remove all the elements that have end time less than the current event's start time
			while(!pq.isEmpty() && pq.peek()[1]<arr[0])
			{
				// Find the maximum value of such events
				maxVal = Math.max(maxVal, pq.poll()[2]);
			}

			// update the res by the maxVal
			res = Math.max(res, maxVal+arr[2]);

			// add the current element to the priority queue
			pq.offer(new int[]{arr[0], arr[1], arr[2]});
		}
		return res;
    }
}