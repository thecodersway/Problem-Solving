public class uniquePaths {
    // int solve(int i,int j,int [][]dp)
    // {
    //     if(i<0||j<0)
    //     {
    //         return 0;
    //     }
    //     if(i==0&&j==0)
    //     return 1;
    //     if(dp[i][j]!=-1)
    //     return dp[i][j];
    //     int up=solve(i-1,j,dp);
    //     int left=solve(i,j-1,dp);
    //     return dp[i][j]= up+left;
    // }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
       dp[0][0]=1;
       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(i==0&&j==0)
            continue;
            int down=0,right=0;
            if(i-1>=0)
             down=dp[i-1][j];
             if(j-1>=0)
              right=dp[i][j-1];
              dp[i][j]=right+down;
        }
       }return dp[m-1][n-1];
    }
}


