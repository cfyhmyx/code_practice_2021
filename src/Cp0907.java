// https://leetcode.com/problems/sum-of-subarray-minimums/

import java.util.Stack;

public class Cp0907 {
    public static void main(String args[]) {
        Cp0907 cp = new Cp0907();
        int[] A = {1,2,3,4};
        int result = cp.sumSubarrayMins(A);
        System.out.println(result);
    }

    // Main idea: monotone stack
    // Time: O(n).
    // Space: O(n).
    public int sumSubarrayMins(int[] A) {
        int len = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < A.length; i++) {
            left[i] = i + 1;
            right[i] = len - i;
        }
        // previous less element, (the left num of ele > cur) + 1 (not strict larger)
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        //next less element, (the right num of ele > cur) + 1 (strict larger)
        stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        long ans = 0;
        long mod = (int) 1e9 + 7;
        for (int i = 0; i < len; i++) {
            ans = (ans + (long) A[i] * left[i] * right[i]) % mod;
        }
        return (int) ans;
    }
}
