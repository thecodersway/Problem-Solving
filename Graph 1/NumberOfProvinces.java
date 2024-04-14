public class NumberOfProvinces
{  //https://leetcode.com/problems/number-of-provinces/
    void dfs(int s, int[][] graph,boolean visited[])
    { 
        visited[s]=true;
       for(int i=0;i<graph.length;i++)
       {
         if(!visited[i]&&graph[s][i]==1)
         dfs(i,graph,visited);
       }
    }
    public int findCircleNum(int[][] isConnected) {
          boolean visited[]=new boolean[isConnected.length];
          int c=0;
          for(int i=0;i<isConnected.length;i++)
          {
            if(!visited[i])
            {
                dfs(i,isConnected,visited);
                c++;
            }
          }return c;
    }
} 

