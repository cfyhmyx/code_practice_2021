// https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import java.util.LinkedList;
import java.util.List;

public class Cp0315 {
    public static void main(String args[]) {
        Cp0315 cp = new Cp0315();
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = cp.countSmaller(nums);
        System.out.println(result);
    }

    class SegTreeNode {
        int min, max;
        int count;
        SegTreeNode left, right;

        public int mid() {
            return (min + (max - min + 1) / 2); // +1 to align with the add logic else condition.
        }

        public SegTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            count = 0;
        }
    }

    // Main idea: segment tree.
    // Time: O(n*log(n)).
    // Space: O(n).
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = min > i ? i : min;
            max = max < i ? i : max;
        }

        SegTreeNode root = new SegTreeNode(min, max);

        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(0, find(nums[i] - 1, root)); // minus 1, in case there will be a equal one
            add(nums[i], root);
        }

        return list;
    }

    private int find(int x, SegTreeNode root) {
        if (root == null) return 0;
        if (x >= root.max) {
            return root.count;
        } else {
            int mid = root.mid();
            if (x < mid) {
                return find(x, root.left);
            } else {
                return find(x, root.left) + find(x, root.right);
            }
        }
    }

    private void add(int x, SegTreeNode root) {
        if (x < root.min || x > root.max) return;
        root.count++;
        if (root.max == root.min) return;

        int mid = root.mid();
        if (x < mid) {
            if (root.left == null) {
                root.left = new SegTreeNode(root.min, mid - 1);
            }
            add(x, root.left);
        } else {
            if (root.right == null) {
                root.right = new SegTreeNode(mid, root.max);
            }
            add(x, root.right);
        }
    }
}
