import java.util.*;
public class pathWithMaxProb {
    //https://leetcode.com/problems/path-with-maximum-probability/
    class pair{
        int node;
        double prob;
        pair(int node,double prob)
        {
            this.node=node;
            this.prob=prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
       ArrayList<pair> adj[]=new ArrayList[n];
       for(int i=0;i<n;i++)
       {
           adj[i]=new ArrayList<>();
       } 
       for(int i=0;i<edges.length;i++)
       {
           adj[edges[i][0]].add(new pair(edges[i][1],succProb[i]));
           adj[edges[i][1]].add(new pair(edges[i][0],succProb[i]));
       }
       double dist[]=new double[n];
       for(int i=0;i<n;i++)
       {
        dist[i]=Integer.MIN_VALUE;
       }
       Comparator<pair> compi=new Comparator<pair>(){
           public int compare(pair p1,pair p2)
        {
            return Double.compare(p2.prob,p1.prob);
        }
       };
       PriorityQueue<pair> q=new PriorityQueue<pair>(compi);
        q.add(new pair(start_node,1));
        dist[start_node]=1;
        while(!q.isEmpty())
        {
           pair p=q.remove();
           int node=p.node;
           double prob=p.prob;
           if(node==end_node)
           return prob;
           for(pair t:adj[node])
           {
            if(dist[t.node]<prob*t.prob)
            {
                dist[t.node]=prob*t.prob;
                q.add(new pair(t.node,dist[t.node]));
            }
           }
        }return 0.00000;
    }
}
