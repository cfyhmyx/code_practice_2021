// https://leetcode.com/problems/convert-to-base-2/

public class Cp1017 {
    public static void main(String args[]) {
    }

    // Main idea: math.
    // Time: O(n).
    // Space: O(1).
    public String baseNeg2(int n) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            res.append(n & 1);
            n = -(n >> 1);
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }
}
