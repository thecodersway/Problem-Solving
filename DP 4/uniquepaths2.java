public class uniquepaths2 {
     //MEM0
    // int solve(int i,int j,int [][]dp,int [][]obstacleGrid)
    // {  
    //     if(i<0||j<0)
    //     {
    //         return 0;
    //     }
    //     if(obstacleGrid[i][j]==1)
    //      return 0;
    //     if(i==0&&j==0)
    //     return 1;
    //     if(dp[i][j]!=-1)
    //     return dp[i][j];
    //     int up=solve(i-1,j,dp,obstacleGrid);
    //     int left=solve(i,j-1,dp,obstacleGrid);
    //     return dp[i][j]= up+left;
    // }
    

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)
               { dp[i][j]=0;
               continue;}
                if(i==0&&j==0)
                continue;
                int down=0;
                int right=0;
               if(i-1>=0)
                 down=dp[i-1][j];
                if(j-1>=0)
             right=dp[i][j-1];
                dp[i][j]=down+right;
            }
        }
       return dp[m-1][n-1];
    }
}

