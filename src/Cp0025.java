// https://leetcode.com/problems/reverse-nodes-in-k-group/

public class Cp0025 {
    public static void main(String args[]) {
    }

    // Main idea: linked list.
    // Time: O(n).
    // Space: O(1).
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}
