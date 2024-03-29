// https://leetcode.com/problems/pancake-sorting/

import java.util.ArrayList;
import java.util.List;

public class Cp0969 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n^2).
    // Space: O(n).
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();

        for (int valueToSort = A.length; valueToSort > 0; valueToSort--) {
            // locate the position for the value to sort in this round
            int index = this.find(A, valueToSort);

            // sink the value_to_sort to the bottom,
            // with at most two steps of pancake flipping.
            if (index == valueToSort - 1)
                continue;
            // 1). flip the value to the head if necessary
            if (index != 0) {
                ans.add(index + 1);
                this.flip(A, index + 1);
            }
            // 2). now that the value is at the head, flip it to the bottom
            ans.add(valueToSort);
            flip(A, valueToSort);
        }

        return ans;
    }

    private void flip(int[] sublist, int k) {
        int i = 0;
        while (i < k / 2) {
            int temp = sublist[i];
            sublist[i] = sublist[k - i - 1];
            sublist[k - i - 1] = temp;
            i += 1;
        }
    }

    private int find(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {

                return i;
            }
        }
        return -1;
    }
}
