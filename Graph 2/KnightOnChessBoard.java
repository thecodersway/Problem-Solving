import java.util.*;
public class KnightOnChessBoard {
    //https://www.interviewbit.com/problems/knight-on-chess-board/
    int directions[][]={{-2,-1},{-2,1},{2,-1},{2,1},{-1,2},{-1,-2},{1,-2},{1,2}};
    class triplet{
        int x;int y;int t;
        triplet(int x,int y,int t)
        {
            this.x=x;
            this.y=y;
            this.t=t;
        }
    }
    int bfs(int n,int m,int x,int y,int d,int d1,boolean[][] visited)
    {
        Queue<triplet> q=new LinkedList<>();
        q.add(new triplet(x,y,0));
        visited[x][y]=true;
        while(!q.isEmpty()){
            triplet p=q.remove();
            
          for(int ar[]:directions)
        {
            int newx=p.x+ar[0];
            int newy=p.y+ar[1];
            if(newx>=0&&newy>=0&&newx<n&&newy<m&&!visited[newx][newy])
            {
                if(newx==d&&newy==d1)
               return p.t+1;
               q.add(new triplet(newx,newy,p.t+1));
               visited[newx][newy]=true; 
            }
        }   
        }return -1;
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        boolean visited[][]=new boolean[A][B];
        if(E==C&&F==D)
        return 0;
        return bfs(A,B,C-1,D-1,E-1,F-1,visited);
        
    }
}


