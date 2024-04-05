
public class RecoveryBST {
    // https://leetcode.com/problems/recover-binary-search-tree/description/
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
     TreeNode element1;
    TreeNode element2;
    boolean foundelement1=false;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    public void helper(TreeNode root) 
    {
        if(root==null)
        return;
        helper(root.left);
        if(root.val<prev.val&&!foundelement1)
        {
            element1=prev;
            element2=root;
            foundelement1=true;
        }
        else if(root.val<prev.val)
        {
            element2=root;
        }prev=root;
        helper(root.right);
    }
    
     public void recoverTree(TreeNode root)
     {
       helper(root);
    int temp=element1.val;
    element1.val=element2.val;
    element2.val=temp;
    }
}
