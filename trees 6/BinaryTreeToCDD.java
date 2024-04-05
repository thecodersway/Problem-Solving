
public class BinaryTreeToCDD {
    //https://www.geeksforgeeks.org/problems/binary-tree-to-cdll/1
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node head = null, prev = null;

    void helper(Node root) {
        if (root == null)
            return;
        helper(root.left);
        if (head == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        helper(root.right);

    }

    Node bTreeToClist(Node root) {
        if (root == null)
            return null;
        helper(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
}
