import java.util.*;
//https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1
public class Friendspairing {
    static int mod=1000000007;
    //       long solve(int n, long[] dp) {
    //         if (n == 0)
    //             return 1;
    //         else if (dp[n] != -1)
    //             return dp[n];
    
    //         long count = 0;
    //         if (n - 2 >= 0)
    //             count = (count + ((n - 1) * solve(n - 2, dp)%mod)%mod)%mod ;
    //         count = (count + solve(n - 1, dp)%mod)%mod;
    
    //         dp[n] = count;
    //         return count;
    //     }
    //     public long countFriendsPairings(int n) 
    //     { 
    //       long dp[]=new long[n+1];
    //       Arrays.fill(dp,-1);;
    //       return solve(n,dp);
    //     }
    // }   
          public long countFriendsPairings(int n) {
            long[] dp = new long[n + 1];
            Arrays.fill(dp, 0);
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                long currentCount = dp[i];
                if (i - 2 >= 0) {
                    currentCount = (currentCount + ((i - 1) * dp[i - 2]) % mod) % mod;
                }
                currentCount = (currentCount + dp[i - 1]) %mod;
                dp[i] = currentCount;
            }
            return dp[n];
        }
    }
    
     
