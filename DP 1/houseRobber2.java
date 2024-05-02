public class houseRobber2 {
    class Solution {
        //https://leetcode.com/problems/house-robber-ii/
        int solve(int n,int nums[])
        {
            int prev=0;
            int prev2=0;
            int curr=0;
            for(int i=0;i<n;i++)
            { 
                int peak=nums[i]+prev2;
                int notpeak=prev;
                 curr=Math.max(peak,notpeak);
                prev2=prev;
                prev=curr;
            }
           
           return prev;
    
        }
        public int rob(int[] nums) {
            int n=nums.length;
            if(n==0)
            return 0;
            if(n==1)
            return nums[0];
            int ar[]=new int[n-1];
            int br[]=new int[n-1];
            int c=0,c1=0;
            for(int i=0;i<n;i++)
            {
                if(i==0)
                ar[c++]=nums[i];
                else if(i==n-1)
                {
                    br[c1++]=nums[i];
                }
                else
                {
                    ar[c++]=nums[i];
                    br[c1++]=nums[i];
                }
            }
           int includingfirst=solve(n-1,ar);
           int includinglast=solve(n-1,br);
           return Math.max(includingfirst,includinglast);
        }
    }
}
