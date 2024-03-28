import java.util.*;
public class BottomleftView {
   // https://leetcode.com/problems/find-bottom-left-tree-value/description/ 
   public class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }}
   public int findBottomLeftValue(TreeNode root) {
        
    if(root==null)
    return -1;
    int t=0;
    Queue<TreeNode> q=new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty())
    {
        int l=q.size();
        for(int i=0;i<l;i++)
        {
            TreeNode temp=q.poll();
         if(i==0)
         t=temp.val;

             if(temp.left!=null)
             q.offer(temp.left);
             if(temp.right!=null)
             q.offer(temp.right);
        }
    }return t;

    }
}

