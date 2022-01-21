// https://leetcode.com/problems/reverse-linked-list-ii/

public class Cp0092 {
    public static void main(String args[]) {
    }

    // Main idea: linked list
    // Time: O(n).
    // Space: O(1).
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode cur = dummy;
        ListNode pre = null;
        while(count<left) {
            pre= cur;
            cur = cur.next;
            count++;
        }
        ListNode next = cur.next;
        while(count<right) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
            count++;
        }
        return dummy.next;
    }
}
