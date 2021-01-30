// https://leetcode.com/problems/merge-two-sorted-lists/

public class Cp0021 {
    public static void main(String args[]) {
        Cp0021 cp = new Cp0021();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;

        ListNode result = cp.mergeTwoLists(n1, n4);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    // Main idea: linked list.
    // Time: O(n).
    // Space: O(1).
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }
}
