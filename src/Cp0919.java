// https://leetcode.com/problems/complete-binary-tree-inserter/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cp0919 {
    public static void main(String args[]) {
    }

    // Main idea: tree
    // Time: O(1) for insert.
    // Space: O(n).
    class CBTInserter {

        private List<TreeNode> list;

        public CBTInserter(TreeNode root) {
            list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                list.add(cur);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        public int insert(int val) {
            int n = list.size();
            int parentIndex = (n - 1) / 2;
            TreeNode newNode = new TreeNode(val);
            TreeNode parentNode = list.get(parentIndex);
            if (n % 2 == 1) {
                parentNode.left = newNode;
            } else {
                parentNode.right = newNode;
            }
            list.add(newNode);
            return parentNode.val;
        }

        public TreeNode get_root() {
            return list.get(0);
        }
    }
}
