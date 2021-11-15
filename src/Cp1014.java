// https://leetcode.com/problems/best-sightseeing-pair/

import java.util.Stack;

public class Cp1014 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, imax = 0;
        for(int i = 0; i < A.length; ++i) {
            res = Math.max(res, imax + A[i] - i);
            imax = Math.max(imax, A[i] + i);
        }
        return res;
    }

    /*public int maxScoreSightseeingPair(int[] values) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0, values[0]});
        for (int i = 1; i < values.length; i++) {
            while (!stack.empty() && values[i] >= stack.peek()[1]) {
                result = Math.max(result, values[i] + stack.peek()[1] + stack.peek()[0] - i);
                stack.pop();
            }
            if (!stack.empty()) {
                result = Math.max(result, values[i] + stack.peek()[1] + stack.peek()[0] - i);
            }
            stack.add(new int[]{i, values[i]});
        }
        return result;
    }*/
}
