import java.util.*;

public class pathsOFtree {
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
    List<String> paths = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root, new StringBuilder());
        return paths;
    }

    public void traverse(TreeNode root, StringBuilder path) {
        if (root.left == null && root.right == null) { // reached a leaf
            path = path.append(root.val);
            paths.add(path.toString());
        } else {
            if (root.left != null) { // explore left node if exist
                StringBuilder subPath = new StringBuilder(path);
                traverse(root.left, subPath.append(root.val + "->"));
            }
            if (root.right != null) { // explore right node if exist
                StringBuilder subPath = new StringBuilder(path);
                traverse(root.right, subPath.append(root.val + "->"));
            }
        }
    }
} 

