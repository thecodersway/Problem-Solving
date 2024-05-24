class DUNGEOn
{//https://leetcode.com/problems/dungeon-game/
        //dp[i][j] represents the minimum health to enter the cell(i,j) after which the current path does
        //not have any value less than 1 while travelling to (n-1)(m-1)
          public int calculateMinimumHP(int[][] dungeon) {
            int n=dungeon.length;
            int m=dungeon[0].length;
            int dp[][]=new int[n][m];
            if(dungeon[n-1][m-1]<=0)
            dp[n-1][m-1]=-1*dungeon[n-1][m-1]+1;
            else
            dp[n-1][m-1]=1;
            for(int i=n-1;i>=0;i--)
            {
              for(int j=m-1;j>=0;j--)
              {  
                  if(i==n-1&&j==m-1)
                  continue;
                  if(i==n-1){
                  if(dungeon[i][j]<=0)
                  {
                      dp[i][j]=Math.abs(dungeon[i][j])+dp[i][j+1];
                  }
                  else 
                      dp[i][j]=Math.max(1,dp[i][j+1]-dungeon[i][j]);
                  }
                  else if(j==m-1)
                  {
                    if(dungeon[i][j]<=0)
                  {
                      dp[i][j]=Math.abs(dungeon[i][j])+dp[i+1][j];
                  }
                    else 
                      dp[i][j]=Math.max(1,dp[i+1][j]-dungeon[i][j]);
                  }  
                  else
                  {
                      if(dungeon[i][j]<=0)
                  {
                      dp[i][j]=Math.abs(dungeon[i][j])+Math.min(dp[i+1][j],dp[i][j+1]);
                  }
                      else 
                        dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
                  }
                }
             }
              return dp[0][0];
          }
      }
