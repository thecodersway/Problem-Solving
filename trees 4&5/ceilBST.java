
public class ceilBST {
    class Node  
     { 
        int data; 
         Node left, right; 
         public Node(int d)  
        { 
            data = d; 
            left = right = null; 
         } 
     }
    int ans=-1;
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if(root==null)
        return ans;
        if(root.data>=key)
        {
            ans=root.data;
           findCeil(root.left,key);
        }
        else
        findCeil(root.right,key);
        return ans;
    }
}

