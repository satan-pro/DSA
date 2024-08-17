public class bny2 {
    
    public static int findMinimumIdleness(String shader, int switchCount) {
        int n = shader.length();
        
        // Calculate initial idleness
        int curr = calc(shader);
        
        // If no switches are allowed or the idleness is already at its minimum (1), return the current idleness
        if (switchCount == 0 || curr == 1) {
            return curr;
        }

        // Iterate over possible ranges to switch and minimize the idleness
        int min = curr;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n && j < i + switchCount; j++) {
                String mod = flp(shader, i, j);
                int news = calc(mod);
                min = Math.min(min, news);
            }
        }

        return min;
    }
    
    // Helper function to calculate the maximum consecutive same characters
    private static int calc(String s) {
        int max = 1, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        max = Math.max(max, curr);
        return max;
    }
    
    // Helper function to flip a range from index i to j
    private static String flp(String s, int i, int j) {
        char[] arr = s.toCharArray();
        for (int k = i; k <= j; k++) {
            arr[k] = arr[k] == 'a' ? 'b' : 'a';
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        // Example test case
        String shader = "aabbbaaaa";
        int switchCount = 2;
        
        int result = findMinimumIdleness(shader, switchCount);
        System.out.println("Minimum possible idleness: " + result); // Output: 2
    }
}
