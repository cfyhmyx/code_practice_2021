// https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

import java.util.List;
import java.util.TreeSet;

public class Cp0363 {
    public static void main(String args[]) {
    }

    // Main idea: prefix sum, treeset.
    // Time: O(m * n * m * log(m)).
    // Space: O(m).
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for(int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for(int right = left; right<n; right++) {
                for(int i=0; i<m; i++) {
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cur = 0;
                for(int sum : sums) {
                    cur += sum;
                    Integer num = set.ceiling(cur-k);
                    if(num != null) {
                        res = Math.max(res, cur-num);
                    }
                    set.add(cur);
                }
            }
        }
        return res;
    }

    //In an array, find the maximum continuous elements, the sum is smaller than k
    /*public int test(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int res = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            int lowLimit = sum - k;
            Integer num = set.ceiling(lowLimit);
            if(num != null) {
                res = Math.max(res, sum-num);
            }
            set.add(sum);
        }
        return sum;
    }*/
}
