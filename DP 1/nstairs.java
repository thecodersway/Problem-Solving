import java.util.Arrays;

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