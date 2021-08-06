import java.util.ArrayList;
import java.util.List;

public class Cp0113 {
    public static void main(String args[]) {
    }

    // Main idea: tree.
    // Time: O(n).
    // Space: O(log(n)).
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, sum, result, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null) {
            if(sum - root.val == 0) {
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, sum-root.val, result, path);
        helper(root.right, sum-root.val, result, path);
        path.remove(path.size()-1);
    }
}
