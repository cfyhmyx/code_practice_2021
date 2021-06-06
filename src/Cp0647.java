// https://leetcode.com/problems/palindromic-substrings/

public class Cp0647 {
    public static void main(String args[]) {
        Cp0647 cp = new Cp0647();
        int result = cp.countSubstrings("abc");
        System.out.print(result);
    }

    // Main idea: two pointers.
    // Time: O(n^2).
    // Space: O(1).
    public int countSubstrings(String str) {
        if (str == null || str.length() < 1) return 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += helper(str, i, i); //Count even sized
            count += helper(str, i, i + 1); //Count odd sized
        }
        return count;
    }

    private int helper(String str, int s, int e) {
        int count = 0;
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
            s--;
            e++;
            count++;
        }
        return count;
    }

    /*public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if (len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                result += dp[i][j] ? 1 : 0;
            }
        }
        return result;
    }*/
}
