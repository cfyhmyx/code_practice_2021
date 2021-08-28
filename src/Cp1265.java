// https://leetcode.com/problems/print-immutable-linked-list-in-reverse/

import java.util.Stack;

public class Cp1265 {
    public static void main(String args[]) {
    }

    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }

    // Main idea: stack, math.
    // Time: O(n).
    // Space: O(sqrt(n)).
    public void printLinkedListInReverse(ImmutableListNode head) {
        // Time: O(n)
        int numNodesCount = getNumNodesCount(head);

        // Time: O(n) Space: O(sqrt(n))
        int step = (int)Math.sqrt(numNodesCount) + 1;
        Stack<ImmutableListNode> headNodes = new Stack<>();
        addNodeWithStep(head, step, headNodes);

        // Time: O(n) Space: O(sqrt(n))
        printEachHeadNodesInReverseOrder(headNodes);
    }

    private int getNumNodesCount(ImmutableListNode head) {
        int count = 0;
        ImmutableListNode node = head;
        while (node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    private void addNodeWithStep(ImmutableListNode head, int step, Stack<ImmutableListNode> headNodes) {
        ImmutableListNode node = head;
        int i = 0;
        while (node != null) {
            if (i % step == 0) {
                headNodes.push(node);
            }
            node = node.getNext();
            i++;
        }
    }

    private void printEachHeadNodesInReverseOrder(Stack<ImmutableListNode> headNodes) {
        ImmutableListNode startNode = null;
        ImmutableListNode endNode = null;
        ImmutableListNode tempNode = null;

        while (!headNodes.isEmpty()) {
            endNode = startNode;
            startNode = headNodes.pop();
            tempNode = startNode;

            Stack<ImmutableListNode> stack = new Stack<>();
            while (tempNode != endNode) {
                stack.push(tempNode);
                tempNode = tempNode.getNext();
            }

            while (!stack.isEmpty()) {
                stack.pop().printValue();
            }
        }
    }
}
