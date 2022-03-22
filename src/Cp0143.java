// https://leetcode.com/problems/reorder-list/

public class Cp0143 {
    public static void main(String args[]) {
    }

    // Main idea: linked list
    // Time: O(n).
    // Space: O(1).
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode preslow = null;
        while(fast != null && fast.next!=null) {
            preslow = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null) {
            preslow = slow;
            slow = slow.next;
        }
        preslow.next = null;
        slow = reverse(slow);
        fast = head;
        ListNode slowNext = null;
        ListNode fastNext = null;
        while(slow != null) {
            slowNext = slow.next;
            fastNext = fast.next;
            fast.next = slow;
            slow.next = fastNext;
            fast = fastNext;
            slow = slowNext;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while(node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
