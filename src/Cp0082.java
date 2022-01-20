// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class Cp0082 {
    public static void main(String args[]) {
    }

    // Main idea: linked list
    // Time: O(n).
    // Space: O(1).
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null) {
            if(p.next.val == p.next.next.val) {
                int sameNum = p.next.val;
                while(p.next != null && p.next.val == sameNum) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
