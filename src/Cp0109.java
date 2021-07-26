// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

public class Cp0109 {
    public static void main(String args[]) {
    }

    // Main idea: recursion, slow and fast pointers.
    // Time: O(n*log(n)).
    // Space: O(log(n)).
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }
}
