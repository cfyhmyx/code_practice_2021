// https://leetcode.com/problems/merge-k-sorted-lists/

public class Cp0023 {
    public static void main(String args[]) {
        Cp0023 cp = new Cp0023();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(8);
        ListNode n7 = new ListNode(3);
        ListNode n8 = new ListNode(6);
        ListNode n9 = new ListNode(9);

        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;

        n7.next = n8;
        n8.next = n9;

        ListNode[] lists = {n1, n4, n7};

        ListNode result = cp.mergeKLists(lists);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    // Main idea: linked list, merge sort.
    // Time: O(n*k), n is the total number of nodes.
    // Space: O(1).
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode list1 = mergeKLists(lists, left, mid);
        ListNode list2 = mergeKLists(lists, mid + 1, right);
        return mergeTwoLists(list1, list2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }
}
