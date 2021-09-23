// https://leetcode.com/problems/can-make-palindrome-from-substring/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cp1177 {
    public static void main(String args[]) {
        Cp1177 cp = new Cp1177();
        String s = "hunu";
        int[][] queries = {{0, 3, 1}};
        List<Boolean> result = cp.canMakePaliQueries(s, queries);
        System.out.print(result);
    }

    // Main idea: prefix sum, (can rearrange).
    // Time: O(n + len), n is queries size
    // Space: O(len).
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int[][] cnt = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); ++i) {
            cnt[i + 1] = cnt[i].clone(); // copy previous sum.
            ++cnt[i + 1][s.charAt(i) - 'a'];
        }
        for (int[] q : queries) {
            int sum = 0;
            for (int i = 0; i < 26; ++i) {
                sum += (cnt[q[1] + 1][i] - cnt[q[0]][i]) % 2;
            }
            ans.add(sum / 2 <= q[2]);
        }
        return ans;
    }

    // Cannot rearrange.
    /*public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] dp = new int[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length() && i + len - 1 < s.length(); i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = 0;
                } else if (j == i + 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : dp[i + 1][j - 1] + 1;
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(dp[query[0]][query[1]] <= query[2]);
        }
        return result;
    }*/
}
