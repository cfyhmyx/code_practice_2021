// https://leetcode.com/problems/divide-two-integers/

public class Cp0029 {
    public static void main(String args[]) {
        Cp0029 cp = new Cp0029();
        int result = cp.divide(-2147483648, -1);
        System.out.println(result);
    }

    // Main idea: binary search, math, num = A*2^a + B*2^b + C*2^c + ...
    // Time: O(log(n)).
    // Space: O(log(n)).
    public int divide(int dividend, int divisor) {
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        if (absDividend < absDivisor) return 0;
        long result = helper(absDividend, absDivisor);
        if (result > Integer.MAX_VALUE) {
            if (sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            return (int) (sign * result);
        }
    }

    private long helper(long absDividend, long absDivisor) {
        if (absDividend < absDivisor) return 0;
        if (absDividend == absDivisor) return 1;
        long sum = absDivisor;
        long multiple = 1;
        while ((sum + sum) <= absDividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + helper(absDividend - sum, absDivisor);
    }
}
