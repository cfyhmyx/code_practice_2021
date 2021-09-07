// https://leetcode.com/problems/partition-list/

public class Cp0086 {
    public static void main(String args[]) {
    }

    // Main idea: two lists.
    // Time: O(n).
    // Space: O(1).
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode smallDummy = new ListNode(0);
        ListNode smallIndex = smallDummy;
        ListNode bigDummy = new ListNode(0);
        ListNode bigIndex = bigDummy;
        while (head != null) {
            if (head.val < x) {
                smallIndex.next = head;
                smallIndex = smallIndex.next;
            } else {
                bigIndex.next = head;
                bigIndex = bigIndex.next;
            }
            head = head.next;
        }
        bigIndex.next = null;
        smallIndex.next = bigDummy.next;
        return smallDummy.next;
    }
}
