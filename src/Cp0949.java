// https://leetcode.com/problems/largest-time-for-given-digits/

public class Cp0949 {
    public static void main(String args[]) {
    }

    // Main idea: iteration.
    // Time: O(1).
    // Space: O(1).
    public String largestTimeFromDigits(int[] arr) {
        String ans = "";
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i == j || i == k || j == k) continue; // avoid duplicate among i, j & k.
                    String h = "" + arr[i] + arr[j];
                    String m = "" + arr[k] + arr[6 - i - j - k];
                    String cur = h + ":" + m; // hour, minutes, & time.
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(cur) < 0) {
                        ans = cur; // hour < 24; minute < 60; update result.
                    }
                }
            }
        }
        return ans;
    }
}
