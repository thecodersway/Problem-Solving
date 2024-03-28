
public class invertTree {
    //https://leetcode.com/problems/invert-binary-tree/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invert1Tree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = invert1Tree(root.right);
        root.right = invert1Tree(temp);
        return root;
    }
}
