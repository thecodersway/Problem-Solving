import java.util.*;
public class courseSchedule2 {
    //https://leetcode.com/problems/course-schedule-ii/
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<Integer> ans=new ArrayList<>();
     ArrayList<Integer> adj[]=new ArrayList[n];
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<>();
        }
       for(int i=0;i<prerequisites.length;i++){
        adj[prerequisites[i][1]].add(prerequisites[i][0]);
       }int deg[]=new int[n];
       for(int i=0;i<n;i++)
       {
        for(int j:adj[i])
         deg[j]++;
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<n;i++)
       {
        if(deg[i]==0)
        q.add(i);
       }
       int c=0;
       while(!q.isEmpty())
       {
        int a=q.remove();
        ans.add(a);
        for(int i:adj[a])
        {
            deg[i]--;
            if(deg[i]==0)
            q.add(i);
        }
       }
       if(ans.size()==n)
      {
        int an[]=new int[n];
        for(int i=0;i<n;i++)
        {
            an[i]=ans.get(i);
        }return an;
      }
       return new int[0];
    }
}

