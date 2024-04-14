import java.util.*;
public class PathExists {
    //https://leetcode.com/problems/find-if-path-exists-in-graph/description/
    boolean dfs(int s, int d, ArrayList<Integer> graph[],boolean visited[]) {
        if(s==d)
        return true;
        visited[s]=true;
        for(int i=0;i<graph[s].size();i++){
        if(!visited[graph[s].get(i)])
         if(dfs(graph[s].get(i),d,graph,visited))
         return true;
         }
        return false;
      }
  
      public boolean validPath(int n, int[][] edges, int source, int destination) {
          ArrayList<Integer> graph[] = new ArrayList[n];
          for (int i = 0; i < n; i++) {
              graph[i] = new ArrayList<Integer>();
          }
          for (int i = 0; i < edges.length; i++) {
              graph[edges[i][0]].add(edges[i][1]);
               graph[edges[i][1]].add(edges[i][0]);
          }boolean visited[]=new boolean[n];
          return dfs(source, destination, graph,visited);
      }
  }

