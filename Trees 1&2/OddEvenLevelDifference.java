import java.util.*;

public class OddEvenLevelDifference {
    // https://www.geeksforgeeks.org/problems/odd-even-level-difference/1
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
	int getLevelDiff(Node root)
	{
	    if(root==null)
	    return 0;
	    Queue<Node> q=new LinkedList<>();
	    q.offer(root);
	    boolean flag=false;
	    int sum=0;
	    while(!q.isEmpty())
	    {
	        int l=q.size();
	        for(int i=0;i<l;i++)
	        {
	            Node t=q.poll();
	            if(flag)
	            {
	                sum-=t.data;
	            }
	            else
	            sum+=t.data;
	            if(t.left!=null)
	            {
	                q.offer(t.left);
	            }
	            if(t.right!=null)
	            {
	                q.offer(t.right);
	            }
	        }flag=!flag;
	    }return sum;
	}
}

