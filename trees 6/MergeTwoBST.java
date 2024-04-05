import java.util.*;

class MergeTwoBST {
    //https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> ar = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        while (root1 != null) {
            stack1.push(root1);
            root1 = root1.left;
        }
        while (root2 != null) {
            stack2.push(root2);
            root2 = root2.left;
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Node current1 = !stack1.isEmpty() ? stack1.peek() : null;
            Node current2 = !stack2.isEmpty() ? stack2.peek() : null;
            if (current1 != null && current2 != null) {
                if (stack1.peek().data == stack2.peek().data) {
                    ar.add(stack1.peek().data);
                    ar.add(stack2.peek().data);
                    root1 = stack1.peek().right;
                    stack1.pop();
                    root2 = stack2.peek().right;
                    stack2.pop();
                } else if (stack1.peek().data > stack2.peek().data) {
                    ar.add(stack2.peek().data);
                    root2 = stack2.peek().right;
                    stack2.pop();
                } else {
                    ar.add(stack1.peek().data);
                    root1 = stack1.peek().right;
                    stack1.pop();
                }
            }
            if (current1 == null) {
                ar.add(stack2.peek().data);
                root2 = stack2.peek().right;
                stack2.pop();
            }
            if (current2 == null) {
                ar.add(stack1.peek().data);
                root1 = stack1.peek().right;
                stack1.pop();
            }
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }
        }
        return ar;
    }
}
