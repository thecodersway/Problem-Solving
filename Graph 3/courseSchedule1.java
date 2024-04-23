import java.util.*;
class courseSchedule1{
    //https://leetcode.com/problems/course-schedule/
boolean dfs(int node,ArrayList<Integer> adj[],boolean visited[], boolean parent[])
{
    visited[node]=true;
    parent[node]=true;
    for(int i:adj[node])
    {
        if(!visited[i]){
        if(!dfs(i,adj,visited,parent))
        return false;}
        else if(visited[i]&&parent[i])
        return false;
    }
    parent[node]=false;
    return true;
}
public boolean canFinish(int n, int[][] prerequisites) {
    ArrayList<Integer> adj[]=new ArrayList[n];
    boolean visited[]=new boolean[n];
    for(int i=0;i<n;i++)
    {
        adj[i]=new ArrayList<>();
    }
   for(int i=0;i<prerequisites.length;i++){
    adj[prerequisites[i][1]].add(prerequisites[i][0]);
   }
   boolean parent[]=new boolean[n];
   for(int i=0;i<n;i++)
  {
    if(!visited[i])
    if(!dfs(i,adj,visited,parent))return false;
  }
 return true;
}
}