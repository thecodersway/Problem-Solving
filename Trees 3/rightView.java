import java.util.*;

class rightView {
    //https://leetcode.com/problems/binary-tree-right-side-view/
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ar = new ArrayList<>();
        if (root == null)
            return ar;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
                if (i == l - 1)
                    ar.add(temp.val);
            }
        }
        return ar;
    }
}