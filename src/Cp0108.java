// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

public class Cp0108 {
    public static void main(String args[]) {
    }

    // Main idea: recursion.
    // Time: O(n).
    // Space: O(log(n)).
    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length;
        TreeNode result = helper(nums, low, high);
        return result;
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if (low >= high) return null;
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
