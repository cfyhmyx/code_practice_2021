// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class Cp0019 {
    public static void main(String args[]) {
    }

    // Main idea: slow and fast pointers.
    // Time: O(n).
    // Space: O(1).
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;

        //fast pointer must be n+1 ahead
        for(int i=0; i<=n; i++)   {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
