import java.util.*;
public class NetworkDelay {
    //https://leetcode.com/problems/network-delay-time/description/
    class pair
    {
        int node;
        int time;
        pair(int node,int time)
        {
            this.node=node;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        n++;
       ArrayList<pair> adj[]=new ArrayList[n];
       for(int i=0;i<n;i++)
       {
        adj[i]=new ArrayList<>();
       } 
       for(int i=0;i<times.length;i++)
       {
        adj[times[i][0]].add(new pair(times[i][1],times[i][2]));
       }
       int dist[]=new int[n];
       for(int i=0;i<n;i++)
       {
        dist[i]=Integer.MAX_VALUE;
       }
       Comparator<pair> compi=new Comparator<pair>(){
        public int compare(pair p1,pair p2)
        {
            return Integer.compare(p1.time,p2.time);
        }
       };
       PriorityQueue<pair> q=new PriorityQueue<>(compi);
       q.add(new pair(k,0));
       dist[k]=0;
       int ans=Integer.MIN_VALUE;
       while(!q.isEmpty())
       {
        pair p=q.remove();
        int node=p.node;
        int time=p.time;
        //ans=Math.max(ans,time);
        for(pair p1:adj[node])
        {
            if(dist[p1.node]>time+p1.time)
            {
                dist[p1.node]=time+p1.time;
                q.add(new pair(p1.node,time+p1.time));
            }
        }
       }
       for(int i=1;i<n;i++)
       {
        if(dist[i]==Integer.MAX_VALUE)
        return -1;
        ans=Math.max(ans,dist[i]);
       }
       return ans;
    }
}