// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
class MinimumDaysBoquets {
    boolean blackbox(int mid,int ar[],int m,int k,int n)
    { int c=0,ans=0;
        for(int i=0;i<n;i++)
        {
            if(ar[i]-mid<=0)
            {
                c++;
            }
            if(ar[i]-mid>0)
            {
                c=0;
            }
            if(c==k)
            {
                c=0;
                ans++;
            }
        }
        return (ans>=m);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)
        return -1;
        int start=0,end=0,ans=-1;
        for(int i=0;i<bloomDay.length;i++)
        {
           start=Math.min(bloomDay[i],start);
           end=Math.max(bloomDay[i],end); 
        }
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(blackbox(mid,bloomDay,m,k,bloomDay.length))
            {
                ans=mid;
                end=mid-1;
            }
            else
            start=mid+1;
        }return ans;
    }
}