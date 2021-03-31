// https://leetcode.com/problems/grumpy-bookstore-owner/

public class Cp1052 {
    public static void main(String args[]) {
        Cp1052 cp = new Cp1052();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int result = cp.maxSatisfied(customers, grumpy, 3);
        System.out.println(result);
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(n).
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int result = 0;
        int[] add = new int[customers.length];
        int maxAdd = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
                add[i] = i == 0 ? 0 : add[i - 1];
            } else {
                add[i] = i == 0 ? customers[i] : add[i - 1] + customers[i];
                maxAdd = Math.max(maxAdd, i >= X ? add[i] - add[i - X] : add[i]);
            }
        }
        return result + maxAdd;
    }
}
