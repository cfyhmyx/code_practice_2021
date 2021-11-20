// https://leetcode.com/problems/string-without-aaa-or-bbb/

public class Cp0984 {
    public static void main(String args[]) {
    }

    // Main idea: greedy.
    // Time: O(n).
    // Space: O(1).
    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder();
        char A = 'a', B = 'b';
        int i = a, j = b;
        if (b > a) {
            A = 'b';
            B = 'a';
            i = b;
            j = a;
        }
        while (i-- > 0) {
            res.append(A);
            if (i > j) {
                res.append(A);
                --i;
            }
            if (j-- > 0) res.append(B);
        }
        return res.toString();
    }
}
