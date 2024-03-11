public class MnimumLimitOfBalls {
    //https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/submissions/1200982857/
   static boolean blackbox(int mid,int nums[],int op)
    {  
        for(int i:nums)
        {

               op-=(i-1)/mid;
        }return (op>=0);
    }
    public int minimumSize(int[] nums, int maxOperations) {
       int start=1;
       int end=Integer.MAX_VALUE;
       int ans=0;
       while(start<=end)
       {
           int mid=start+(end-start)/2;
           if(blackbox(mid,nums,maxOperations))
           {
               ans=mid;
               end=mid-1;
           }
           else
           start=mid+1;
       }return ans;
    }
}

