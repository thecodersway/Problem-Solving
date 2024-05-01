public class Bipartite {
    boolean dfs(int i,int col,int[][] graph,int[] ar)
    {
       ar[i]=col;
        for(int j:graph[i])
        {
            if(ar[j]==-1)
            {
                ar[j]=1-col;
            if(dfs(j,1-col,graph,ar)==false)
            return false;
            }
               else if(ar[i]==ar[j])
                return false;
            
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int ar[]=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            ar[i]=-1;
        }
        for(int i=0;i<graph.length;i++)
        {
            if(ar[i]==-1)
            {//ar[i]=0;
            if(dfs(i,0,graph,ar)==false)
            return false;
            }
        }return true;
    }
}