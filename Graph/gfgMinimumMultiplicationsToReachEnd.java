import java.util.*;
class gfgMinimumMultiplicationsToReachEnd 
{
	int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()) {
        	int[] pair = pq.poll();
        	int currStart = pair[0];
        	int currSteps = pair[1];

        	for(int n: arr)
        	{	
        		int nextStart = (currStart*n)%100000;
        		
                if(currSteps+1 < dist[nextStart]) {
                    dist[nextStart] = currSteps+1;

                    if(nextStart==end)
                        return currSteps+1;
                    pq.offer(new int[]{nextStart, currSteps+1});
                }
        	}
        }

        return dist[end]==Integer.MAX_VALUE?-1:dist[end];
    }
}