import java.util.ArrayList;
import java.util.List;
//https://www.naukri.com/code360/problems/boundary-traversal-of-binary-tree_790725?leftPanelTabValue=PROBLEM
public class BoundaryTraversal {
     public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
         TreeNode(int data) {
            this.data = data;
        }
         TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static void left(TreeNode root,List<Integer> ar)
    {
        if(root==null)
        return;
        if(root.left!=null||root.right!=null)
        ar.add(root.data);
          if(root.left==null)
          left(root.right,ar);
          else 
          left(root.left,ar);
    }
    static void leaf(TreeNode root,List<Integer> ar)
    { if (root==null)
    return;
        if(root.left==null&&root.right==null)
       { ar.add(root.data);
       return;}
        leaf(root.left,ar);
        leaf(root.right,ar);
    }
    static void right(TreeNode root,List<Integer> ar)
    {
        if(root==null)
        return;
          if(root.right==null)
          right(root.left,ar);
          else 
          right(root.right,ar);
           ar.add(root.data);
    }
    public static List<Integer> traverseBoundary(TreeNode root){

        List<Integer> ar=new ArrayList<>();
          if(root==null)
        return ar;
        ar.add(root.data);
       left(root.left,ar);
      leaf(root,ar);
      if(root.right!=null)
      ar.remove(ar.size()-1);
       right(root.right,ar);
       return ar;
    }
}

