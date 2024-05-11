class Numberofdicerolls
{//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
    //    static final int MOD = 1000000007;
//     int numRollsToTarget(int n, int k, int target) {
//         return numR(n, k, target, new Integer[n + 1][target + 1]);
//     }

//     private int numR(int n, int k, int target, Integer[][] memo) {
//         if (n < 0)
//             return 0;
//         if (n == 0 && target == 0)
//             return 1;
//         if (n != 0 && target == 0)
//             return 0;
//         if (n == 0 && target != 0)
//             return 0;
//         if (memo[n][target] != null)
//             return memo[n][target];

//         int ways = 0;
//         for (int i = 1; i <= k; i++) {
//             if (target - i >= 0) {
//                 ways = (ways + numR(n - 1, k, target - i, memo)) % MOD;
//             }
//         }
//         memo[n][target] = ways;
//         return ways;
//     }
// }
//dp[i][j] signifies number of ways to achieve the sum j using i dice

    public int numRollsToTarget(int numDice, int numFaces, int targetSum) {
        int[][] dp = new int[numDice + 1][targetSum + 1];
        dp[0][0] = 1; 
        int mod = (int) 1e9 + 7;
        
        for (int dice = 1; dice <= numDice; dice++) {
            for (int currentSum = 0; currentSum <= targetSum; currentSum++) {
                for (int faceValue = 1; faceValue <= numFaces; faceValue++) {
                    if (currentSum >= faceValue) {
                        dp[dice][currentSum] = (dp[dice][currentSum] + dp[dice - 1][currentSum - faceValue]) % mod; 
                    }
                }
            }
        }
        
        return dp[numDice][targetSum];
    }
}

