import java.util.*;
public class CheapestFlight {
    //https://leetcode.com/problems/cheapest-flights-within-k-stops/
    class tuple{
        int stops;
        int node;
        int cost;
        tuple(int stops,int node,int cost)
        {
            this.stops=stops;
            this.node=node;
            this.cost=cost;
        }
     }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    ArrayList<ArrayList<Integer>> adj[]=new ArrayList[n];
      for(int i=0;i<n;i++)
      {
          adj[i]=new ArrayList<>();
      } 
      for(int i=0;i<flights.length;i++)
      {
        ArrayList<Integer> an=new ArrayList<>();
        an.add(flights[i][1]);
        an.add(flights[i][2]);
        adj[flights[i][0]].add(an);
      } 
      int dist[]=new int[n];
      for(int i=0;i<n;i++)
      {
        dist[i]=Integer.MAX_VALUE;
      }
      Queue<tuple> tu=new LinkedList<>();
       tu.add(new tuple(0,src,0));
       dist[src]=0;
       while(!tu.isEmpty())
       {
        tuple t=tu.remove();
        int stops=t.stops;
       int node=t.node;
        int cost=t.cost;
        if(stops>k)continue;
        for(int i=0;i<adj[node].size();i++)
        {
            int newnode=adj[node].get(i).get(0);
            int newcost=adj[node].get(i).get(1);
            if(newcost+cost<dist[newnode])
            {
                dist[newnode]=newcost+cost;
                tu.add(new tuple(stops+1,newnode,dist[newnode]));
            }
        }  
       }if(dist[dst]==Integer.MAX_VALUE)
       return -1;
       return dist[dst];
    }
}
