import java.util.Arrays;

public class houseRobber1 {
    //https://leetcode.com/problems/house-robber/
  int solve(int index,int nums[],int dp[])
    {
        if(index==0)
        return nums[index];
        else if(index<0)
        return 0;
        if(dp[index]!=-1)
        return dp[index];
        int peak=nums[index]+solve(index-2,nums,dp);
        int notpeak=solve(index-1,nums,dp);
       return dp[index]=Math.max(peak,notpeak);

    }
    public int rob(int[] nums) {

        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums.length-1,nums,dp);
    }
}  

