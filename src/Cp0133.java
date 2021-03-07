// https://leetcode.com/problems/clone-graph/

import java.util.*;

public class Cp0133 {
    public static void main(String args[]) {
    }

    // Main idea: bfs.
    // Time: O(V+E)
    // Space: O(V).
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node cloneNode = new Node(node.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, cloneNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node ne : cur.neighbors) {
                Node neClone = map.get(ne);
                if (neClone == null) {
                    queue.add(ne);
                    neClone = new Node(ne.val);
                }
                map.put(ne, neClone);
                map.get(cur).neighbors.add(neClone);
            }
        }
        return map.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
