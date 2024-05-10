public class Brainpower {
    //ofcouse the recurrsive solution gives TLE
//     long solve(int[][] nums,int index)
//      { 
//          if(index==nums.length-1)
//         {
//             return (long)nums[index][0];
//         }
//         if(index>nums.length-1)
//         return 0;
//         long nottake=solve(nums,index+1);
//         long take=solve(nums,index+nums[index][1]+1)+nums[index][0];
//         return Math.max(nottake,take);
//     }
//     public long mostPoints(int[][] questions) {
//         return solve(questions,0);
//     }
// }
//MEMOIZATION
// long solve(int[][] nums,int index,long dp[])
//      { 
//          if(index==nums.length-1)
//         {
//             return (long)nums[index][0];
//         }
//         if(index>nums.length-1)
//         return 0;
//         if(dp[index]!=-1)
//         return dp[index];
//         long nottake=solve(nums,index+1,dp);
//         long take=solve(nums,index+nums[index][1]+1,dp)+nums[index][0];
//         return dp[index]=Math.max(nottake,take);
//     }
//     public long mostPoints(int[][] questions) {
//         long dp[]=new long[questions.length+1];
//         Arrays.fill(dp,-1);
//         return solve(questions,0,dp);
//     }
// }
//TABULATION
 public long mostPoints(int[][] questions) {
    int n = questions.length;
       long[] dp = new long[n];
       dp[n-1] = questions[n-1][0];
       for (int i = n-2; i >= 0; i--) {
             if(i+questions[i][1]+1 < dp.length) 
           dp[i] = Math.max(dp[i + 1],questions[i][0]+dp[i+questions[i][1]+1]);
           else
           dp[i]=Math.max(dp[i + 1],questions[i][0]);;
       }
       return dp[0];
   }
}