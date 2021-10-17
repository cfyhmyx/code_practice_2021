// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

import java.util.HashMap;
import java.util.Map;

public class Cp1171 {
    public static void main(String args[]) {
    }

    // Main idea: map.
    // Time: O(n).
    // Space: O(n).
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);
        int sum = 0;
        while (cur != null) {
            sum += cur.val;
            if (map.containsKey(sum)) {
                ListNode remove = map.get(sum).next;
                int removeSum = sum;
                while (remove != cur) {
                    removeSum += remove.val;
                    map.remove(removeSum);
                    remove = remove.next;
                }
                map.get(sum).next = cur.next;
            } else {
                map.put(sum, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
