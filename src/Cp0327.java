// https://leetcode.com/problems/count-of-range-sum/

import java.util.*;

public class Cp0327 {
    public static void main(String args[]) {
        Cp0327 cp = new Cp0327();
        int[] nums = {-2, 5, -1};
        int result = cp.countRangeSum(nums, -2, 2);
        System.out.println(result);
    }

    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;

        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
        if (low > high) return null;
        SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
        if (low == high) return stn;
        int mid = (low + high) / 2;
        stn.left = buildSegmentTree(valArr, low, mid);
        stn.right = buildSegmentTree(valArr, mid + 1, high);
        return stn;
    }

    private void updateSegmentTree(SegmentTreeNode stn, Long val) {
        if (stn == null) return;
        if (val >= stn.min && val <= stn.max) {
            stn.count++;
            updateSegmentTree(stn.left, val);
            updateSegmentTree(stn.right, val);
        }
    }

    private int getCount(SegmentTreeNode stn, long min, long max) {
        if (stn == null) return 0;
        if (min > stn.max || max < stn.min) return 0;
        if (min <= stn.min && max >= stn.max) return stn.count;
        return getCount(stn.left, min, max) + getCount(stn.right, min, max);
    }

    // Main idea: segment tree.
    // Time: O(n*log(n)).
    // Space: O(n).
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        Set<Long> set = new HashSet<>();
        set.add((long)0);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            set.add(sum);
        }
        Long[] arr = set.toArray(new Long[0]);
        Arrays.sort(arr);
        SegmentTreeNode root = buildSegmentTree(arr, 0, arr.length - 1);
        sum = 0;
        for(int i = 0; i<nums.length; i++) {
            updateSegmentTree(root, sum);
            sum += nums[i];
            ans += getCount(root, sum-upper, sum-lower);
        }
        return ans;
    }

    // Main idea: treemap.
    // Time: O(n*log(n)).
    // Space: O(n).
    /*public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        treeMap.put((long) 0, (long) 1);
        long prefixSum = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            Map<Long, Long> sub = treeMap.subMap(prefixSum - upper, true, prefixSum - lower, true);
            for (Long value : sub.values()) {
                count += value;
            }
            treeMap.put(prefixSum, treeMap.getOrDefault(prefixSum, (long) 0) + 1);
        }
        return (int) count;
    }*/

}
