// https://leetcode.com/problems/intersection-of-two-linked-lists/

public class Cp0160 {
    public static void main(String args[]) {
    }

    // Main idea: linked list
    // Time: O(n).
    // Space: O(1).
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
