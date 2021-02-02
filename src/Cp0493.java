// https://leetcode.com/problems/reverse-pairs/

import java.util.List;

public class Cp0493 {
    public static void main(String args[]) {
        Cp0493 cp = new Cp0493();
        int[] nums = {1,3,2,3,1};
        int result = cp.reversePairs(nums);
        System.out.println(result);
    }


    class SegmentTreeNode {
        long min;
        long max;
        int count = 0;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public long mid() {
            return (min + (max - min) / 2);
        }

        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
            count = 0;
        }
    }

    // Main idea: segment tree.
    // Time: O(n*log(n)).
    // Space: O(n).
    public int reversePairs(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        SegmentTreeNode root = new SegmentTreeNode(min, max);
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            result += getCount(root, nums[i]);
            addNode(root, nums[i]);
        }
        return result;
    }

    private int getCount(SegmentTreeNode node, int num) {
        if (node == null) return 0;
        if (num / 2.0 > node.max) {
            return node.count;
        } else {
            long mid = node.mid();
            if (num / 2.0 <= mid) {
                return getCount(node.left, num);
            } else {
                return getCount(node.left, num) + getCount(node.right, num);
            }
        }
    }

    private void addNode(SegmentTreeNode node, int num) {
        if (node.min > num || node.max < num) {
            return;
        }
        node.count++;
        if (node.max == node.min) return;
        long mid = node.mid();
        if (num <= mid) {
            if (node.left == null) {
                node.left = new SegmentTreeNode(node.min, mid);
            }
            addNode(node.left, num);
        } else {
            if (node.right == null) {
                node.right = new SegmentTreeNode(mid + 1, node.max);
            }
            addNode(node.right, num);
        }
    }
}
