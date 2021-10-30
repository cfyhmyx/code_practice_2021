// https://leetcode.com/problems/adding-two-negabinary-numbers/

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Cp1073 {
    public static void main(String args[]) {
    }

    // Main idea: math.
    // Time: O(n).
    // Space: O(n).
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1;
        int  j = arr2.length - 1;
        int carry = 0;
        Stack<Integer> stack = new Stack<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += arr1[i--];
            if (j >= 0) carry += arr2[j--];
            stack.push(carry & 1);
            carry = - (carry >> 1);
        }
        while (!stack.isEmpty() && stack.peek() == 0) {
            stack.pop();
        }
        int[] res = new int[stack.size()];
        if (stack.isEmpty()) return new int[]{0};
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
}
