import java.util.*;

public class verticalOrderTraversal {
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
    static class pairs{
          int x;
          int y;
          TreeNode node;

          pairs(TreeNode node,int x,int y)
          {
            this.node=node;
            this.x=x;
            this.y=y;
          }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
        return result;
        Queue<pairs> q=new LinkedList<>();
        Map<Integer,PriorityQueue<pairs>> map=new TreeMap<>();
        q.offer(new pairs(root,0,0));
         Comparator<pairs> comparator = (a, b) -> {
            if (a.x == b.x) {
                if (a.y == b.y)
                    return a.node.val - b.node.val; 
                return a.y - b.y;
            } else {
                return a.x - b.x;
            }
        };
        while(!q.isEmpty())
        {
            pairs n=q.poll();
            TreeNode t=n.node;
            int x=n.x;
            int y=n.y;
            if(!map.containsKey(n.x))
            {
                map.put(n.x,new PriorityQueue<>(comparator));
            }
            map.get(n.x).add(n);
            if(t.left!=null)
            {
                q.offer(new pairs(t.left,x-1,y+1));
            }
             if(t.right!=null)
            {
                q.offer(new pairs(t.right,x+1,y+1));
            }
        }
        for(Map.Entry<Integer,PriorityQueue<pairs>> temp:map.entrySet())
        {  
            ArrayList<Integer> a=new ArrayList<>();
          
         
         while(!temp.getValue().isEmpty())
           {
            a.add(temp.getValue().poll().node.val);
           }result.add(a);
        }return result;
    }
}

