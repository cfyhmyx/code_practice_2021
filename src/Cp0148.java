// https://leetcode.com/problems/sort-list/

public class Cp0148 {
    public static void main(String args[]) {
        Cp0148 cp = new Cp0148();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode result = cp.sortList(n1);

        while(n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    // Main idea: linked list, merge sort.
    // Time: O(n*log(n)).
    // Space: O(1).
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //set fast as the head of second list
        fast = slow.next;
        slow.next =null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(fast);
        return mergeTwoLists(l1,l2);
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        while(left != null && right != null) {
            int v1 = left.val;
            int v2 = right.val;
            if(v1 <= v2) {
                index.next = left;
                left = left.next;
            } else {
                index.next = right;
                right = right.next;
            }
            index = index.next;
        }
        if(left != null) {
            index.next = left;
        } else {
            index.next = right;
        }
        return dummy.next;
    }
}
