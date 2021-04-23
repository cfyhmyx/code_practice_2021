// https://leetcode.com/problems/replace-the-substring-for-balanced-string/

public class Cp1234 {
    public static void main(String args[]) {
        Cp1234 cp = new Cp1234();
        int result = cp.balancedString("QQWE");
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int balancedString(String s) {
        int[] count = new int[128];
        int n = s.length();
        int k = n / 4;
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        int result = n;
        while (right < n) {
            count[s.charAt(right)]--;
            right++;
            while (left < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
                result = Math.min(result, right - left);
                count[s.charAt(left)]++;
                left++;
            }
        }
        return result;
    }
}
