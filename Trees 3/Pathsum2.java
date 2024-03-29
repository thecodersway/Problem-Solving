import java.util.*;

public class Pathsum2 {
    // https://leetcode.com/problems/path-sum-ii/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    void helper(TreeNode root, int target, List<Integer> ans, List<List<Integer>> op) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && target == root.val) {
            ans.add(root.val);
            op.add(new ArrayList<>(ans));
            ans.remove(ans.size() - 1);
            return;
        }
        ans.add(root.val);
        helper(root.left, target - root.val, ans, op);
        helper(root.right, target - root.val, ans, op);
        ans.remove(ans.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> op = new ArrayList<>();
        helper(root, targetSum, ans, op);
        return op;
    }
}
