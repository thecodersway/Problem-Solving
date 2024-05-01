import java.util.*;
class kosaRajualgo
{//https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean []visited,Stack<Integer> s)
    {
        visited[node]=true;
        for(int i:adj.get(node))
        {  if(!visited[i])
            dfs(i,adj,visited,s);
        }
        s.push(node);
    }
    static void dfs2(int node,ArrayList<Integer> adj[],boolean[] visited)
    {
        visited[node]=true;
        for(int i:adj[node])
        {  if(!visited[i])
            dfs2(i,adj,visited);
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //ranking
        boolean visited[]=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                dfs(i,adj,visited,st);
            }
        }
        //reversing
        ArrayList<Integer> ar[]=new ArrayList[V];
        for(int i=0;i<V;i++)
        {
            ar[i]=new ArrayList<>();
        }
        for(int i=0;i<V;i++)
        {   visited[i]=false;
            for(int j=0;j<adj.get(i).size();j++)
            {
              ar[adj.get(i).get(j)].add(i);   
            }
        }
        int c=0;
       while(!st.isEmpty())
        {
            int i=st.pop();
         if(!visited[i])
         { c++;
             dfs2(i,ar,visited);
         }
        }
        return c;
    }
}

