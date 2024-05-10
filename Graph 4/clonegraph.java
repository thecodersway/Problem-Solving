import java.util.*;
public class clonegraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    void dfs(Node node,Node clone,HashMap<Node,Node> map)
    {
      for(Node n:node.neighbors)
      {
        if(map.get(n)==null)
        {
            Node temp=new Node(n.val);
            map.put(n,temp);
            clone.neighbors.add(temp);
            dfs(n,temp,map);
        }
        else
        {
             clone.neighbors.add(map.get(n));
        }
      }
    }
    public Node cloneGraph(Node node) {
        if(node==null)
        return null;
        HashMap<Node,Node> map=new HashMap<>();
        Node clone=new Node(node.val);
        map.put(node,clone);
        dfs(node,clone,map);
     return clone;
    }
}

