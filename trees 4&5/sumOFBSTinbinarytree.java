import javax.swing.tree.TreeNode;

class sumOFBSTinbinarytree
{
   //https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
   public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
     TreeNode(int val) {
        this.val = val;
    }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
    int ans=Integer.MIN_VALUE;
    class nodeinfo{
        int sum;
        boolean isbst;
        int min;
        int max;
        nodeinfo(){}
        nodeinfo(int sum,boolean isbst,int min,int max)
      {
        this.sum=sum;
        this.isbst=isbst;
        this.min=min;
        this.max=max;
      }
    }
    nodeinfo helper(TreeNode root)
    {
        if(root==null)
        return new nodeinfo(0,true,Integer.MAX_VALUE,Integer.MIN_VALUE);
        nodeinfo leftsubtree=helper(root.left);
        nodeinfo rightsubtree=helper(root.right);
        nodeinfo ob=new nodeinfo();
        ob.isbst=(leftsubtree.isbst&&rightsubtree.isbst)&&(root.val>leftsubtree.max&&root.val<rightsubtree.min);
        ob.min=Math.min(root.val,leftsubtree.min);
        ob.max=Math.max(root.val,rightsubtree.max);
        if(ob.isbst)
        {
            ob.sum=root.val+leftsubtree.sum+rightsubtree.sum;
        }
        else
        ob.sum=Math.max(leftsubtree.sum,rightsubtree.sum);
        ans=Math.max(ans,ob.sum);
        return ob;
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        if(ans<0)
        return 0;
       return ans;
        
    }
}
