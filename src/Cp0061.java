// https://leetcode.com/problems/rotate-list/

public class Cp0061 {
    public static void main(String args[]) {
    }

    // Main idea: linked list.
    // Time: O(n).
    // Space: O(1).
    public ListNode rotateRight(ListNode head, int k ) {
        if(head == null || head.next == null) return head;
        ListNode index = head;
        int len = 1;
        while(index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;
        for(int i=1; i<len-k%len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }
}
