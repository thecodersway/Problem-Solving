import java.util.LinkedList;
import java.util.Queue;

public class searlizeandDesearlize {
    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
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
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {

            TreeNode temp = q.poll();
            if (temp != null)
                s.append(temp.val + " ");
            else {
                s.append("n ");
                continue;
            }
            if (temp.left != null) {
                q.offer(temp.left);
            } else
                q.offer(null);
            if (temp.right != null) {
                q.offer(temp.right);
            } else
                q.offer(null);
        }
        System.out.println(s.toString());
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        String ar[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ar[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < ar.length; i++) {
            TreeNode t = q.poll();
            if (ar[i].charAt(0) != 'n')

            {
                TreeNode left = new TreeNode(Integer.parseInt(ar[i]));
                t.left = left;
                q.offer(left);
            } else
                t.left = null;
            if (ar[++i].charAt(0) != 'n')

            {
                TreeNode right = new TreeNode(Integer.parseInt(ar[i]));
                t.right = right;
                q.offer(right);
            } else
                t.right = null;

        }
        return root;
    }
}
