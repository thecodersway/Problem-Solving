import java.util.*;
public class detectCycle {
    //https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
    static boolean dfs(int s,ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean path[])
    {
        visited[s]=true;
        path[s]=true;
        for(int i:adj.get(s))
        {
            if(!visited[i])
            {
                if(dfs(i,adj,visited,path))
                return true;
            }
            else if(path[i])
            return true;
        }
        path[s]=false;
        return false;
    }
  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean visited[]=new boolean[V];
    boolean path[]=new boolean[V];
    for(int i=0;i<V;i++)
    {
        if(!visited[i])
       { if(dfs(i,adj,visited,path))
           return true;
       }   
    }  return false;
    
    
  }
}

