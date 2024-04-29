import java.util.*;
public class MinimumTimeTOVisitDisappearingNodes {
    //https://leetcode.com/problems/minimum-time-to-visit-disappearing-nodes/
    class pair{
        int node;
        int cost;
        pair(int node,int cost)
        {
            this.node=node;
            this.cost=cost;
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<pair> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            adj[edges[i][0]].add(new pair(edges[i][1],edges[i][2]));
            adj[edges[i][1]].add(new pair(edges[i][0],edges[i][2]));
        }
         boolean[] visited = new boolean[n];
        int dist[]=new int[n];
        for(int i=0;i<n;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        Comparator<pair> compi=new Comparator<pair>(){
            public int compare(pair t1,pair t2)
            {
                return Integer.compare(t1.cost,t2.cost);
            }
        };
        PriorityQueue<pair> q=new PriorityQueue<pair>(compi);
        q.add(new pair(0,0));
        dist[0]=0;
        while(!q.isEmpty())
        {
            pair p=q.remove();
            int node=p.node;
            int cost=p.cost;
            if(visited[node])continue;
            visited[node]=true;
            for(pair t:adj[node])
            {
                if(dist[t.node]>(cost+t.cost)&&cost+t.cost<disappear[t.node])
                {
                    dist[t.node]=cost+t.cost;
                    q.add(new pair(t.node,dist[t.node]));
                }
            }
        }
       for(int i=0;i<n;i++)
       {
        if(dist[i]==Integer.MAX_VALUE)
            dist[i]=-1;
       }
       return dist;
    }
}

