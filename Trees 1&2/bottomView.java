import java.util.*;
//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class bottomView {//
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class pairs {
        int x;
        int y;
        Node node;

        pairs(Node node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public ArrayList<Integer> bottom1View(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<pairs> q = new LinkedList<>();
        Map<Integer, Stack<pairs>> map = new TreeMap<>();
        q.offer(new pairs(root, 0, 0));

        while (!q.isEmpty()) {
            pairs n = q.poll();
            Node t = n.node;
            int x = n.x;
            int y = n.y;
            if (!map.containsKey(n.x)) {
                map.put(n.x, new Stack<>());
            }
            map.get(n.x).add(n);
            if (t.left != null) {
                q.offer(new pairs(t.left, x - 1, y + 1));
            }
            if (t.right != null) {
                q.offer(new pairs(t.right, x + 1, y + 1));
            }
        }
        for (Map.Entry<Integer, Stack<pairs>> temp : map.entrySet()) {
            result.add(temp.getValue().pop().node.data);
        }
        return result;
    }
}
