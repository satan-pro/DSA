import java.util.*;

public class bny1 {
    public static int minFountains(int[] locations) {
        int n = locations.length;
        int[] maxReach = new int[n];
        
        // Calculate the maximum reach for each fountain
        for (int i = 0; i < n; i++) {
            int left = Math.max(i - locations[i], 0);
            int right = Math.min(i + locations[i], n);
            maxReach[left] = Math.max(maxReach[left], right);
        }
        
        // Count the minimum number of fountains needed
        int count = 0;
        int currEnd = 0;
        int nextEnd = 0;
        
        for (int i = 0; i < n; i++) {
            nextEnd = Math.max(nextEnd, maxReach[i]);
            
            if (i == currEnd) {
                count++;
                currEnd = nextEnd;
                
                if (currEnd >= n - 1) {
                    return count;
                }
            }
        }
        
        return count; // If it's not possible to cover the entire garden
    }

    public static void main(String[] args) {
        int[] locations = {2,0,0,0};
        System.out.println("Minimum fountains to activate: " + minFountains(locations));
    }
}