import java.util.ArrayList;

public class pathToGivenNode {
    // https://www.interviewbit.com/problems/path-to-given-node/
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
     boolean helper(TreeNode root,int target,ArrayList<Integer> ar)
    {
        if(root==null)
        {
            return false ;
        }  ar.add(root.val);
        if(root.val==target)
        {
         return true; 
        }   
    if(helper(root.left,target,ar)|| helper(root.right,target,ar))
    return true;
        ar.remove(ar.size()-1);
        return false;
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ar=new ArrayList<>();
        if(A==null)
        return ar;
        helper(A,B,ar);
        return ar;
    }
}

