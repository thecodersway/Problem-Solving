
class validateBst { 
    //https://leetcode.com/problems/validate-binary-search-tree/description/
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

    boolean helper(TreeNode root, long left, long right) {
        if (root == null)
            return true;
        if ((root.val <= left) || (root.val >= right))
            return false;
        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
