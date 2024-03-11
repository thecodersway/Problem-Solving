import java.util.Arrays;

public class Agressivecows {
    //https://www.geeksforgeeks.org/problems/aggressive-cows/1
  static boolean blackbox(int mid,int ar[],int k,int n){
      Arrays.sort(ar);
       int ans=ar[0];
       k--;
       for(int i=1;i<n;i++)
       {
         
         if(Math.abs(ar[i]-ans)>=mid)
         {
             k--;
             ans=ar[i];
         }
       }
       return (k<=0);
   }
    public static int solve(int n, int k, int[] stalls) {
        int start=1;
        int min=Integer.MAX_VALUE,max=0;
        for(int i=0;i<n;i++)
        {
            min=Math.min(min,stalls[i]);
            max=Math.max(max,stalls[i]);
        }
        if(n<k)
        return -1;
        if(n==1&&k==1)
        return 0;
        int end=max-min;
       int  ans=-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(blackbox(mid,stalls,k,n))
            {
                ans=mid;
                start=mid+1;
            }
            else
            end=mid-1;
        }return ans;
    }
}

