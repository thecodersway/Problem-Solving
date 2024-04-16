import java.util.*;
public class Number_of_Islands {
    //https://leetcode.com/problems/number-of-islands/description/
    int directions[][]={{1,0},{-1,0},{0,1},{0,-1}};
    class pair{
        int x;
        int y;
        pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    void bfs(int i,int j,char[][] grid,boolean visited[][])
    {
       Queue<pair> q=new LinkedList<>();
       q.add(new pair(i,j));
        visited[i][j]=true;
       while(!q.isEmpty())
       {
        pair p=q.remove();
        int x=p.x;
        int y=p.y;
        for(int ar[]:directions)
        {
            int newx=x+ar[0];
            int newy=y+ar[1];
            if(newx>=0&&newx<grid.length&&newy>=0&&newy<grid[0].length&&grid[newx][newy]=='1'&&
            !visited[newx][newy])
            {   visited[newx][newy]=true;
                q.add(new pair(newx,newy));
            }
        }
       }
    }
    public int numIslands(char[][] grid) {
        
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int c=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1'&&!visited[i][j])
                {
                    bfs(i,j,grid,visited);
                    c++;
                }
            }
        }return c;
    }
}
