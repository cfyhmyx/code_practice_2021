// https://leetcode.com/problems/linked-list-cycle/

public class Cp0141 {
    public static void main(String args[]) {
        Cp0141 cp = new Cp0141();
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        boolean result = cp.hasCycle(n1);
        System.out.println(result);
    }

    // Main idea: two pointers.
    // Time: O(n).
    // Space: O(1).
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
