// https://leetcode.com/problems/online-stock-span/

import java.util.Stack;

public class Cp0901 {
    public static void main(String args[]) {
    }

    // Main idea: monotone stack
    // Time: O(n).
    // Space: O(n).
    class StockSpanner {

        private Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                count += stack.pop()[1];
            }
            stack.add(new int[]{price, count});
            return count;
        }
    }
}
