// https://leetcode.com/problems/linked-list-cycle/

public class Cp0142 {
    public static void main(String args[]) {
        Cp0142 cp = new Cp0142();
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

        ListNode result = cp.detectCycle(n1);
        System.out.println(result.val);
    }

    // Main idea: two pointers.
    // move k step, slow and fast meet, 2k-k = r, r is the length of circle.
    // s: the distance between start node and the start node of circle.
    // m: the distance between the start node of cycle and the meet point.
    // s = k-m = r-m
    // Time: O(n).
    // Space: O(1).
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
