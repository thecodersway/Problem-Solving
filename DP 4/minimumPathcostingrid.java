import java.util.Arrays;

class minimumPathcostingrid
{
     int solve(int[][] grid,int row,int col,int m,int n,int [][]cost,int [][]dp)
    {
        if(row==m-1&&col<n)
        return grid[row][col];
        if(dp[row][col]!=-1)
        return dp[row][col];
        int min=Integer.MAX_VALUE;
     for(int j=0;j<grid[0].length;j++)
     {
        min=Math.min(grid[row][col]+cost[grid[row][col]][j]+solve(grid,row+1,j,m,n,cost,dp),min);
        
     }
      return dp[row][col]=min;
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(dp[i],-1);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        ans=Math.min(ans,solve(grid,0,i,m,n,moveCost,dp));
        return ans;
    }
}
