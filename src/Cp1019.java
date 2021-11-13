// https://leetcode.com/problems/next-greater-node-in-linked-list/

import java.util.Stack;

public class Cp1019 {
    public static void main(String args[]) {
        Cp1019 cp = new Cp1019();
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        int[] result = cp.nextLargerNodes(n1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        int index = 0;
        while (head != null) {
            while (!stack.empty() && head.val > stack.peek()[1]) {
                result[stack.peek()[0]] = head.val;
                stack.pop();
            }
            stack.add(new int[]{index++, head.val});
            head = head.next;
        }
        return result;
    }
}
