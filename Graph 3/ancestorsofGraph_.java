import java.util.*;
public class ancestorsofGraph_ {
    //https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
          adj[i]=new ArrayList<>();
        } 
        int degree[]=new int[n];
        for(int i=0;i<edges.length;i++)
        {
          adj[edges[i][0]].add(edges[i][1]);
          degree[edges[i][1]]++;
        } 
        Queue<Integer> q=new LinkedList<>();
        List<TreeSet<Integer>> ans=new ArrayList<>();
      for(int i=0;i<n;i++)
      {    ans.add(new TreeSet<>());
          if(degree[i]==0)
          {
            q.add(i);
          }
      }
      while(!q.isEmpty())
      {
          int a=q.remove();
         for(int i:adj[a])
         {
          for(int j:ans.get(a))
          {
              ans.get(i).add(j);
          }
          ans.get(i).add(a);
          degree[i]--;
          if(degree[i]==0)
          {
              q.add(i);
          }
         }
      }  List<List<Integer>> re = new ArrayList<>();
      for (int i = 0; i < n; i++) {
          re.add(new ArrayList<>(ans.get(i)));
      }
      return re;
  }
  }

