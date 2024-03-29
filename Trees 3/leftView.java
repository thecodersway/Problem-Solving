import java.util.*;

public class leftView {
    //https://www.naukri.com/code360/problems/left-view-of-binary-tree_625707?leftPanelTabValue=PROBLEM
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void printLeftView(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                TreeNode temp = q.poll();
                if (i == 0)
                    System.out.print(temp.data + " ");
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
        }
    }
}
