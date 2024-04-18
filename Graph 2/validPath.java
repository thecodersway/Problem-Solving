import  java.util.*;
public class validPath {
    //https://www.interviewbit.com/problems/valid-path/
    static int directions[][]={{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,-1},{-1,1},{1,1}};
    static boolean dfs(int x,int y,int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F,boolean[][] visited)
     {
         if(x<0||y<0||x>A||y>B)
         return false;
         if( visited[x][y]||within(x,y,C,D,E,F))
         return false;
         if(x==A&&y==B)
         return true;
         visited[x][y]=true;
         for(int ar[]:directions)
         {
             int newx=x+ar[0];
             int newy=y+ar[1];
             if(dfs(newx,newy,A,B,C,D,E,F,visited))
             return true;
         }return false;
     }
     static boolean within(int x,int y,int n,int r,ArrayList<Integer> E, ArrayList<Integer> F)
     {
         for(int i=0;i<n;i++)
         {
             int a=E.get(i);
             int b=F.get(i);
             a=a-x;
             b=b-y;
             int d=a*a+b*b;
             if(r*r>=d)
             return true;
         }
         return false;
     }
     public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        boolean visited[][]=new boolean[A+1][B+1];
        
         if(dfs(0,0,A,B,C,D,E,F,visited))
         return "YES";
         return "NO";
     }
 }
 

