// https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/

import java.util.ArrayList;
import java.util.List;

public class Cp1253 {
    public static void main(String args[]) {
        Cp1253 cp = new Cp1253();
        int[] colsum = {2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
        List<List<Integer>> result = cp.reconstructMatrix(5, 5, colsum);
        System.out.print(result);
    }

    // Main idea: greedy.
    // Time: O(n).
    // Space: O(1).
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> up = new ArrayList<>(), lo = new ArrayList<>();
        int diff = upper - lower, sum = 0;
        for (int i : colsum) {
            sum += i;
            if (i % 2 == 0) {
                up.add(i / 2);
                lo.add(i / 2);
            } else {
                if (diff >= 0) {
                    up.add(1);
                    lo.add(0);
                    diff--;
                } else {
                    up.add(0);
                    lo.add(1);
                    diff++;
                }
            }
        }
        if (diff != 0 || upper + lower != sum) return res;
        res.add(up);
        res.add(lo);
        return res;
    }

    /*public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[][] local = new int[2][colsum.length];
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        for (int col : colsum) {
            sum += col;
        }
        if (sum != upper + lower) return result;
        if (!helper(0, upper, lower, colsum, local)) {
            return result;
        }
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        result.add(row1);
        result.add(row2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < colsum.length; j++) {
                result.get(i).add(local[i][j]);
            }
        }
        return result;
    }

    private boolean helper(int index, int upper, int lower, int[] colsum, int[][] local) {
        if (upper < 0 || lower < 0) return false;
        if (index == colsum.length) {
            if (upper == 0 && lower == 0) {
                return true;
            }
            return false;
        }
        if (colsum[index] == 0) {
            return helper(index + 1, upper, lower, colsum, local);
        } else if (colsum[index] == 2) {
            local[0][index] = 1;
            local[1][index] = 1;
            return helper(index + 1, upper - 1, lower - 1, colsum, local);
        } else {
            local[0][index] = 1;
            if (helper(index + 1, upper - 1, lower, colsum, local)) {
                return true;
            } else {
                local[0][index] = 0;
                local[1][index] = 1;
                return helper(index + 1, upper, lower - 1, colsum, local);
            }
        }
    }*/
}
