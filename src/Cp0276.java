public class Cp0276 {
    public static void main(String args[]) {
        Cp0276 cp = new Cp0276();
        int result = cp.numWays(3, 2);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        int dp_i_s = 0;
        int dp_i_d = k;
        for (int i = 2; i <= n; i++) {
            int temp = dp_i_s;
            dp_i_s = dp_i_d;
            dp_i_d = (temp + dp_i_d) * (k - 1);
        }
        return dp_i_s + dp_i_d;
    }
}
