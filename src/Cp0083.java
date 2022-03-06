// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class Cp0083 {
    public static void main(String args[]) {
    }

    // Main idea: linked list
    // Time: O(n).
    // Space: O(1).
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(cur.val == pre.val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
