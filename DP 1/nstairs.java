import java.util.Arrays;
//this is the recurrsive solution which gives TLE
//     public int climbStairs(int n) {
//          if(n<1)
//         return 0;
//         if(n==1)
//         return 1;
//         if(n==2)
//         return 2;
//         return climbStairs(n-1)+climbStairs(n-2);
//     }
// }
//Memoization approach dp[i] represent maximum ways to reach i
//  int usingDP(int n,int ar[])
//     {   
//         if(n==1)
//         return 1;
//         else if(n==2)
//         return 2;
//         if(ar[n]!=-1)
//         return ar[n];
//          ar[n]=usingDP(n-1,ar)+usingDP(n-2,ar);
//          return ar[n];
//     }
//     public int climbStairs(int n) {
//         int ar[]=new int[n+1];
//         Arrays.fill(ar,-1);
//         return usingDP(n,ar);
//     }
// }
class nstairs
{
     int usingDP(int n,int ar[])
    {   
        if(n==1)
        return 1;
        else if(n==2)
        return 2;
        if(ar[n]!=-1)
        return ar[n];
         ar[n]=usingDP(n-1,ar)+usingDP(n-2,ar);
         return ar[n];
    }
    public int climbStairs(int n) {
        int ar[]=new int[n+1];
        Arrays.fill(ar,-1);
        return usingDP(n,ar);
    }

}
