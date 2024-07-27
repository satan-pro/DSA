import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class microsoft1 {

    boolean adjacent(String tile1, String tile2) {
        return tile1.charAt(0) == tile2.charAt(1) || tile1.charAt(1) == tile2.charAt(0);
    }

    public int solution(String[] A) {
        // Implement your solution here
        int[] dp = new int[A.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (adjacent(A[i], A[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int i = 0; i < A.length; i++) {
            longest = Math.max(longest, dp[i]);
        }

        return longest;
}
}
