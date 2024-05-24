public class lcs {
    //https://leetcode.com/problems/longest-common-subsequence/submissions/889173445/
 static int lcs(String X,String Y,int m,int n,int[][] dp){
      
        if (m == 0 || n == 0)
          return 0;
      
        if (dp[m][n] != -1)
          return dp[m][n];
      
        if(X.charAt(m - 1) == Y.charAt(n - 1)){
          dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
          return dp[m][n];
        }
      
        dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp),lcs(X, Y, m - 1, n, dp));
        return dp[m][n];
      }
        public int longestCommonSubsequence(String text1, String text2) {
             int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0;i<m + 1;i++){
          for(int j=0;j<n + 1;j++){
            dp[i][j] = -1;
          }}
         int ans= lcs(text1, text2, m, n, dp);
         return ans;
     
        }
    }  

