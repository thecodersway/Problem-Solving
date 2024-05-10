import java.util.ArrayList;
//https://leetcode.com/problems/shortest-cycle-in-a-graph/
public class shortestCycle {
     int min=(int)1e9;
    public void dfs(ArrayList<ArrayList<Integer>>arr,int n,int vis[],int length,int parent)
    {
        vis[n]=1;
        for(int a:arr.get(n))
        {
            if(vis[a]==1&&a!=parent)
            {
                min=Math.min(length+1,min);
            }
            else
            {
               if(a!=parent&&(length+1<min))
               {
                   
                  
                dfs(arr,a,vis,length+1,n);
               }
            
            }
        }
        vis[n]=0;
        
    }
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>arr=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++)
        {
            arr.add(new ArrayList<Integer>());

        }
        for(int i=0;i<edges.length;i++)
        {
            arr.get(edges[i][0]).add(edges[i][1]);
             arr.get(edges[i][1]).add(edges[i][0]);
            
        } 
        int visited[]=new int[n];
        for(int i=0;i<n;i++)
        {
            dfs(arr,i,visited,0,-1);
        }
        if(min==(int)1e9)
        {
            return -1;
        }
        return min;

    }
}  
  

