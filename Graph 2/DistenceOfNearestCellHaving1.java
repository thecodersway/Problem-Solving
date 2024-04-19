import java.util.*;
public class DistenceOfNearestCellHaving1 {
    //https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
    static int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
   static class triplet{
        int x;int y;int t;
        triplet(int x,int y,int t)
        {
            this.x=x;
            this.y=y;
            this.t=t;
        }
    }
     static void bfs(Queue<triplet> q,int [][]nums,int[][] ans)
    {
        boolean visited[][]=new boolean[nums.length][nums[0].length];
        while(!q.isEmpty())
        {
            triplet p=q.remove();
            int x=p.x;
            int y=p.y;
            int t=p.t;
            visited[x][y]=true;
           for(int ar[]:directions)
           {
           int newx=x+ar[0];
           int newy=y+ar[1];
            if(newx>=0&&newy>=0&&newx<nums.length&&newy<nums[0].length&&!visited[newx][newy]&&nums[newx][newy]==0)
            {
                ans[newx][newy]=t+1;
                q.add(new triplet(newx,newy,t+1));
                visited[newx][newy]=true;
            }
           }
        }
    }
    public int[][] nearest(int[][] nums)
    {
       int n=nums.length;
        int m=nums[0].length;
        Queue<triplet> q=new LinkedList<>();

     int ans[][]=new int[n][m];
     for(int i=0;i<n;i++)
     {
        for(int j=0;j<m;j++)
       {
        if(nums[i][j]==1)
        {
            q.add(new triplet(i,j,0));
            ans[i][j]=0;
        }
       }
     } 
     bfs(q,nums,ans);  
     return ans;
    }
}

