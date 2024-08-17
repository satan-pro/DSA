import java.util.*;

public class bny3 {
    public static int superBitstrings(int n, int[] bitStrings) {
        Set<Integer> set = new HashSet<>();

        for (int decimal : bitStrings) {
            // Convert decimal to binary string of length n
            String bin = String.format("%" + n + "s", Integer.toBinaryString(decimal)).replace(' ', '0');
            
            // Generate all super bit strings
            calc(bin, 0, 0L, set);
        }

        return set.size();
    }

    private static void calc(String bin, int index, int curr, Set<Integer> set) {
        if (index == bin.length()) {
            set.add(curr);
            return;

        // If the current bit is '1' or we flip '0' to '1'
        calc(bin, index + 1, curr | (1L << (bin.length() - 1 - index)), set);

        // If the current bit is '0', we also have the option to keep it as '0'
        if (bin.charAt(index) == '0') {
            calc(bin, index + 1, curr, set);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[] bitStrings = {2,6};
        System.out.println("Number of unique super bit strings: " + superBitstrings(n, bitStrings));
    }
}