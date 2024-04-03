
public class largestBst {
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
    static class infonode{
        int size;
        boolean isbst;
        int min;
        int max;
        infonode(){}
        infonode(int size,boolean isbst,int min,int max)
        {
            this.size=size;
            this.isbst=isbst;
            this.min=min;
            this.max=max;
        }
    }
    static infonode largest(Node root)
    {
        if(root==null)
        return new infonode(0,true,Integer.MAX_VALUE,Integer.MIN_VALUE);
        infonode leftsubtree=largest(root.left);
        infonode rightsubtree=largest(root.right);
        infonode ob=new infonode();
        ob.isbst=(leftsubtree.isbst&&rightsubtree.isbst)&&(root.data>leftsubtree.max&&root.data<rightsubtree.min);
        ob.min=Math.min(root.data,leftsubtree.min);
        ob.max=Math.max(root.data,rightsubtree.max);
        if(ob.isbst)
        ob.size=1+leftsubtree.size+rightsubtree.size;
        else
        ob.size=Math.max(leftsubtree.size,rightsubtree.size);
        return ob;
    }
    static int largestBst(Node root)
    {
        return largest(root).size;
    }
}
