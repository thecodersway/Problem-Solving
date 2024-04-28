import java.util.*;

public class SmallestCityThresholdDisteance {
    class pair{
        int node;
        int weight;
        pair(int node,int weight)
        {
            this.node=node;
            this.weight=weight;
        }
    }
    int reachedcity(int src, ArrayList<pair> adj[],int threshold,int n)
    {
        int ans=0;
        int dist[]=new int[n];
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        Comparator<pair> compi=new Comparator<pair>(){
            public int compare(pair p1,pair p2)
            {
                return Integer.compare(p1.weight,p2.weight);
            }
        };
        PriorityQueue<pair> q=new PriorityQueue<>(compi);
        q.add(new pair(src,0));
       while(!q.isEmpty())
       {
        pair p=q.remove();
        int node=p.node;
        int weight=p.weight;
        for(pair t:adj[node])
        {
            if(t.weight+weight<=threshold && dist[t.node]>t.weight+weight)
            {   
                dist[t.node]=t.weight+weight;
                q.add(new pair(t.node,weight+t.weight));
                set.add(t.node);
            }
        }
       }return set.size();
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      ArrayList<pair> adj[]=new ArrayList[n];
       for(int i=0;i<n;i++)
       {
        adj[i]=new ArrayList<>();
       }
       for(int i=0;i<edges.length;i++)
       {
        adj[edges[i][0]].add(new pair(edges[i][1],edges[i][2]));
         adj[edges[i][1]].add(new pair(edges[i][0],edges[i][2]));
       }int an=Integer.MAX_VALUE;
       int minroutenode=-1;
      for(int i=0;i<n;i++)
      {
        int a=reachedcity(i,adj,distanceThreshold,n);
        if(a<=an)
        {
            an=a;
            minroutenode=i;
        }
      }return minroutenode;
    }
}
