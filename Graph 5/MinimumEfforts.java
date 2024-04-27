import java.util.*;
class MinimumEfforts
{//https://leetcode.com/problems/path-with-minimum-effort/description/
    int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
    class triplet{
        int x;
        int y;
        int dif;
        triplet(int x,int y,int dif)
        {
            this.x=x;
            this.y=y;
            this.dif=dif;
        }
    }
    public int minimumEffortPath(int[][] grid) {
      int n=grid.length;
        int m=grid[0].length;
     int dist[][]=new int[n][m];
     for(int i=0;i<n;i++)
     {
        for(int j=0;j<m;j++)
        {
            dist[i][j]=Integer.MAX_VALUE;
        }
     }
     Comparator<triplet> compi=new Comparator<triplet>(){
        public int compare(triplet t1,triplet t2)
        {
            return Integer.compare(t1.dif,t2.dif);
        }
     };   
     PriorityQueue<triplet> q=new PriorityQueue<triplet>(compi);
     q.add(new triplet(0,0,0));
     while(!q.isEmpty())
     {
        triplet t=q.remove();
        int x=t.x;
        int y=t.y;
        int dif=t.dif;
        if(x==n-1&&y==m-1)
        return dif;
        for(int ar[]:directions)
        { 
            int newx=x+ar[0];
            int newy=y+ar[1];
            if(newx>=0&&newy>=0&&newx<n&&newy<m)
            {   int effort=Math.max(Math.abs(grid[x][y]-grid[newx][newy]),dif);
            if(dist[newx][newy]>effort){
               dist[newx][newy]=effort;
               q.add(new triplet(newx,newy,dist[newx][newy]));
            }
            }
        }
     }return -1;
    }
}   
   
