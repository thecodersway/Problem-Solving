//https://leetcode.com/problems/binary-tree-level-order-traversal/description/


import java.util.*;
class LevelOrderTraversal{
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

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ar=new ArrayList<>();
    if(root==null)
    return ar;
    Queue<TreeNode> q=new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty())
    {
        ArrayList<Integer> tem=new ArrayList<>();
        int l=q.size();
        for(int i=0;i<l;i++)
        {
            TreeNode temp=q.poll();
          
            tem.add(temp.val);

             if(temp.left!=null)
             q.offer(temp.left);
             if(temp.right!=null)
             q.offer(temp.right);
        }
         ar.add(tem);
    }return ar;
}
}