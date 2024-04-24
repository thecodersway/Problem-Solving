import java.util.*;
//https://www.geeksforgeeks.org/problems/minimum-edges/1
public class Minimum_edges {
    static class pair{
        int x;int y;
        pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
     public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
         n++;
        ArrayList<pair> adj[]=new ArrayList[n];
         for(int i=0;i<n;i++)
         {
             adj[i]=new ArrayList<>();
         }
         
        for (int i = 0; i < m; i++) {
             int u = edges[i][0];
             int v = edges[i][1];
             adj[u].add(new pair(v,0));
              adj[v].add(new pair(u,1));
         }
 
         boolean visited[]=new boolean[n];
         Deque<pair> deque = new LinkedList<>();
         deque.addFirst(new pair(src,0));
        
         while(!deque.isEmpty())
         {
             pair p=deque.removeFirst();
             if(p.x==dst)
             return p.y;
             visited[p.x]=true;
             for(pair i:adj[p.x])
             {   if(!visited[i.x])
              {
                 if(i.y==0)
                 {
                   deque.addFirst(new pair(i.x,p.y+0));  
                 }
                 else
                 {
                    deque.addLast(new pair(i.x,p.y+1));  
                 }
              }
             }
         }
         return -1;
     }
 }
         
 
