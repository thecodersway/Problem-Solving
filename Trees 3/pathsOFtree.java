import java.util.*;
//https://leetcode.com/problems/binary-tree-paths/description/
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
        if (root.left == null && root.right == null) {
            path = path.append(root.val);
            paths.add(path.toString());
        } else {
            if (root.left != null) { 
                StringBuilder subPath = new StringBuilder(path);
                traverse(root.left, subPath.append(root.val + "->"));
            }
            if (root.right != null) {
                StringBuilder subPath = new StringBuilder(path);
                traverse(root.right, subPath.append(root.val + "->"));
            }
        }
    }
} 

