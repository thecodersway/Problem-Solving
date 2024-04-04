//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
class kthSmallestinBST
{  public class TreeNode {
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
    static  int c=0;
    static int n=0;
    void helper(TreeNode root)
   {
    if(root.left!=null)
    helper(root.left);
    c--;
    if(c==0)
    {
        n=root.val;
        return;
    }
    if(root.right!=null)
    helper(root.right);
   }
    public int kthSmallest(TreeNode root, int k) {
        c=k;
       helper(root);
       return n;
    }
}
