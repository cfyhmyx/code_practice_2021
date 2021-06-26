// https://leetcode.com/problems/add-two-numbers/

import java.util.List;

public class Cp0002 {
    public static void main(String args[]) {

    }

    // Main idea: linked list.
    // Time: O(n).
    // Space: O(1).
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode index = dummy;

        while(l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            index.next = new ListNode((num1+num2+carry) % 10);
            carry = (num1+num2+carry)/10;
            index = index.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }

        if(carry != 0) {
            index.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
