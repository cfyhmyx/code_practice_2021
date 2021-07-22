// https://leetcode.com/problems/swap-nodes-in-pairs/

public class Cp0024 {
    public static void main(String args[]) {
    }

    // Main idea: recursion.
    // Time: O(n).
    // Space: O(n).
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
