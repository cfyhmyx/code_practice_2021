// https://leetcode.com/problems/insertion-sort-list/

public class Cp0147 {
    public static void main(String args[]) {
        Cp0147 cp = new Cp0147();
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode result = cp.insertionSortList(n1);

        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    // Main idea: linked list.
    // Time: O(n^2).
    // Space: O(1).
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        // pre is the last node of the sorted list.
        ListNode pre = dummy;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;

            if (pre.val > cur.val) {
                pre = dummy;
            }

            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
