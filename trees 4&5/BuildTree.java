
public class BuildTree {
    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
     TreeNode helper(int[] ar,int start,int end)
     {
        if(start>end)
        return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(ar[mid]);
        root.left= helper(ar,start,mid-1);
        root.right=helper(ar,mid+1,end);
        return root;
     }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
}

