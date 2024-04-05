
public class BSTcontructionFromPREORDER {
    //https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
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
     TreeNode helper(int ar[],int index,int n)
    {
        if(index>n)
        return null;
        TreeNode root=new TreeNode(ar[index]);
        int i=index+1;
        while(i<=n && ar[i]<ar[index])
        {
            i++;
        }
        root.left=helper(ar,index+1,i-1);
        root.right=helper(ar,i,n);
        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
}

