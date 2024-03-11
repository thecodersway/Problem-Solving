public class sqrt {
    // https://leetcode.com/problems/sqrtx/submissions/1199910881/
    public int mySqrt(int x) {
        long start=0,end=x/2;
        if(x==1)
        return 1;
        long ans=-1;
        while(start<=end)
        {
            long mid=start+(end-start)/2;
            if(mid*mid==x)
            return (int)mid;
            else if(mid*mid<x)
            {
                ans=mid;
                start=mid+1;
            }
            else
            end=mid-1;
        }  return (int)ans;  
        }
}
