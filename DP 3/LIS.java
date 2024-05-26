import java.util.*;
//https://leetcode.com/problems/longest-increasing-subsequence/
class LIS
{
     /*
     * this is the recurrsive solution thst gives TLE
     * int solve(int index,int [] nums,int prev)
     * { if(index==nums.length)
     * return 0;
     * int take=0;
     * if(nums[index]>prev)
     * take=1+solve(index+1,nums,nums[index]);
     * int nottake=solve(index+1,nums,prev);
     * int ans=Math.max(take,nottake);
     * return ans;
     * }
     * public int lengthOfLIS(int[] nums) {
     * int prev=Integer.MIN_VALUE;
     * return solve(0,nums,prev);
     * }
     * }
     */
    /*
     * this is the memoization approach
     * IT RUNS BUT IT IT WILL FAIL FOR THE CONSTRAINT 2^5 AS THE DP ARRAY OF SIZE
     * 2^10 IS NOT POSSIBLE
     * int solve(int index,int [] nums,int prev,int dp[][])
     * { if(index==nums.length)
     * return 0;
     * if(dp[index][prev+1]!=-1)
     * return dp[index][prev+1];
     * int take=0;
     * if(prev==-1||nums[index]>nums[prev])
     * take=1+solve(index+1,nums,index,dp);
     * int nottake=solve(index+1,nums,prev,dp);
     * return dp[index][prev+1]=Math.max(take,nottake);
     * }
     * public int lengthOfLIS(int[] nums) {
     * int prev=Integer.MIN_VALUE;
     * int dp[][]=new int[nums.length][nums.length];
     * for(int i=0;i<nums.length;i++)
     * {
     * Arrays.fill(dp[i],-1);
     * }
     * return solve(0,nums,-1,dp);
     * }
     * }
     */
    /*
     * this is the Bottom up(tabulation approach)
     * DP[i] represents the maximum subsequence at the end of the index i including nums[i]
     * here the space is also optimised
     * public int lengthOfLIS(int[] nums) {
     * int ans=1;
     * int n=nums.length;
     * int dp[] = new int[n];
     * dp[0] =1;
     * for (int i=1; i < n; i++) {
     * int max_lis_just_before = 0;
     * for (int j = 0;j<i;j++) {
     * if (nums[i] > nums[j])
     * max_lis_just_before = Math.max(max_lis_just_before, dp[j]);
     * }
     * dp[i] = max_lis_just_before + 1;
     * ans = Math.max(ans, dp[i]);
     * }
     * return ans;
     * }
     * }
     */


  //this is the most optimised approach it takes nlogn time 
  int helper(ArrayList<Integer> ar, int start, int end, int tar) {
    int ans=-1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (ar.get(mid) == tar) {
            ans = mid;
            break;
        } else if (ar.get(mid) < tar) {
            start = mid + 1;
        } else {
            ans = mid;
            end = mid - 1;
        }
    }
    return ans;
}

public int lengthOfLIS(int[] nums) {
    ArrayList<Integer> ar = new ArrayList<>();
    ar.add(nums[0]);
    int n = nums.length;
    for (int i = 1; i < n; i++) {
        if (ar.get(ar.size() - 1) < nums[i])
            ar.add(nums[i]);
        else {
            int ans = helper(ar, 0, ar.size() - 1, nums[i]);
            ar.set(ans, nums[i]);
        }
    }
    return ar.size();
}
}
