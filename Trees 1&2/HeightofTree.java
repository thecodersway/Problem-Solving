import java.util.*;



public class HeightofTree {
    //https://www.naukri.com/code360/problems/tree-height_4609628?leftPanelTabValue=PROBLEM
    public static int heightOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        return 1+Math.max(heightOfBinaryTree(root.left),heightOfBinaryTree(root.right));
    }
}
