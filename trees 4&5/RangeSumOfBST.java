
public class RangeSumOfBST {
    //https://leetcode.com/problems/range-sum-of-bst/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
         TreeNode(int data) {
            this.val = data;
        }
         TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
     int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
       if(root==null)
       return 0;
       if(root.val>=low&&root.val<=high)
      { sum+=root.val;
         rangeSumBST(root.right,low,high);
          rangeSumBST(root.left,low,high);}
      else if(root.val<low)
       {
         rangeSumBST(root.right,low,high);
       }
       else if(root.val>high)
       {
         rangeSumBST(root.left,low,high);
       }
       return sum;
    }
}

