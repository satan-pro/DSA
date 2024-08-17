import java.util.*;

/*public class bny4 {
    public static int getMinToolRuns(int[] serverLoad, int k) {
        int n = serverLoad.length;
        if (n <= k) return 0; // If we can manually offload all servers, no need to use the tool

        // Sort the server loads in descending order
        Integer[] sortedLoad = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedLoad[i] = serverLoad[i];
        }
        Arrays.sort(sortedLoad, Collections.reverseOrder());

        int toolRuns = 0;
        int remainingServers = n;

        for (int i = 0; i < n; i++) {
            if (i < k) {
                // Manually offload the k highest load servers
                remainingServers--;
                continue;
            }

            int highestLoad = sortedLoad[i];
            int threshold = (highestLoad + 1) / 2; // Ceiling division

            // Count servers that need to be offloaded by the tool
            int serversToOffload = 0;
            for (int j = i; j < n && sortedLoad[j] > threshold; j++) {
                serversToOffload++;
            }

            if (serversToOffload > 0) {
                toolRuns++;
                remainingServers -= serversToOffload;
                i += serversToOffload - 1; // Skip the servers that were offloaded
            }

            if (remainingServers <= k) {
                // If remaining servers can be manually offloaded, we're done
                break;
            }
        }

        return toolRuns;
    }

    public static void main(String[] args) {
        // Test cases
        int[] serverLoad1 = {6, 12, 18, 10, 12};
        int k1 = 2;
        System.out.println("Test case 1: " + getMinToolRuns(serverLoad1, k1)); // Expected: 1

        int[] serverLoad2 = {2, 4, 6, 9};
        int k2 = 1;
        System.out.println("Test case 2: " + getMinToolRuns(serverLoad2, k2)); // Expected: 0

        int[] serverLoad3 = {10, 7, 15, 1, 4, 20};
        int k3 = 3;
        System.out.println("Test case 3: " + getMinToolRuns(serverLoad3, k3)); // Expected: 2

        int[] serverLoad4 = {100};
        int k4 = 0;
        System.out.println("Test case 4: " + getMinToolRuns(serverLoad4, k4)); // Expected: 1

        int[] serverLoad5 = {1, 1, 1, 1, 1};
        int k5 = 5;
        System.out.println("Test case 5: " + getMinToolRuns(serverLoad5, k5)); // Expected: 0
    }
}
*/


/*
public class bny4 {
    public static void main(String[] args) {
        int[] serverLoad = {6, 12, 18, 10, 12};
        int k = 2;
        System.out.println(getMinToolRuns(serverLoad, k));
    }

    public static int getMinToolRuns(int[] serverLoad, int k) {
        Arrays.sort(serverLoad);
        int n = serverLoad.length;
        int res = 0;
        int i = n - 1;
        while (i >= 0 && k > 0) {
            i--;
            k--;
        }
        while (i >= 0) {
            int maxLoad = serverLoad[i--];
            int halfLoad = maxLoad / 2;
            while (i >= 0 && serverLoad[i] > halfLoad) {
                i--;
            }
            res++;
        }
        return res;
    }
}
*/

//import java.util.Arrays;
//import java.util.Collections;

/*public class bny4 {
    public static int getMinToolRuns(int[] serverLoad, int k) {
        int n = serverLoad.length;
        
        // Sort the server loads in descending order
        Arrays.sort(serverLoad);
        Integer[] sortedLoads = Arrays.stream(serverLoad).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedLoads, Collections.reverseOrder());
        
        int toolRuns = 0;
        int i = 0;
        
        while (i < n) {
            // Manually offload tasks from k servers
            int serversToManuallyOffload = Math.min(k, n - i);
            i += serversToManuallyOffload;
            
            if (i < n) {
                toolRuns++;
                
                // Find the highest load L in the remaining servers
                int L = sortedLoads[i];
                
                // Offload tasks from all servers with workload > L/2
                while (i < n && sortedLoads[i] > L / 2) {
                    i++;
                }
            }
        }
        
        return toolRuns;
    }

    public static void main(String[] args) {
        // Example test case
        int[] serverLoad = {2, 4, 6, 9};
        int k = 1;
        
        int result = getMinToolRuns(serverLoad, k);
        System.out.println("Minimum tool runs: " + result); // Output: 1
    }
    */

//import java.util.Arrays;

public class bny4 {

    public static int getMinToolRuns(int[] serverLoad, int k) {
        int n = serverLoad.length;

        // Sort the server loads in descending order
        Arrays.sort(serverLoad);
        
        // Manually offload the highest k servers
        int remainingServers = n - k;
        if (remainingServers <= 0) {
            // If all servers can be offloaded manually, no tool run is required
            return 0;
        }

        int toolRuns = 0;
        while (remainingServers > 0) {
            // Identify the server with the highest load in the remaining servers
            int maxLoad = serverLoad[remainingServers - 1];
            
            // Offload tasks from servers with workloads strictly greater than maxLoad/2
            int threshold = maxLoad / 2;
            int newRemainingServers = 0;
            for (int i = 0; i < remainingServers; i++) {
                if (serverLoad[i] > threshold) {
                    newRemainingServers++;
                }
            }
            remainingServers = newRemainingServers;
            toolRuns++;
        }

        return toolRuns;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] serverLoad1 = {6, 12, 18, 10, 12};
        int k1 = 2;
        System.out.println("Minimum tool runs: " + getMinToolRuns(serverLoad1, k1)); // Output: 1

        // Test case 2: All servers can be offloaded manually
        int[] serverLoad2 = {6, 12, 18};
        int k2 = 3;
        System.out.println("Minimum tool runs: " + getMinToolRuns(serverLoad2, k2)); // Output: 0

        // Test case 3: No manual offloading allowed
        int[] serverLoad3 = {6, 12, 18, 10, 12};
        int k3 = 0;
        System.out.println("Minimum tool runs: " + getMinToolRuns(serverLoad3, k3)); // Output: 2

        // Test case 4: Only one server
        int[] serverLoad4 = {18};
        int k4 = 0;
        System.out.println("Minimum tool runs: " + getMinToolRuns(serverLoad4, k4)); // Output: 0
    }
}


