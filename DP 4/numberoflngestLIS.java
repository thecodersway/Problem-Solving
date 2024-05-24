public class numberoflngestLIS {
    //     int t=0;
//     int helper(ArrayList<Integer> ar, int start, int end, int tar) {
//         int ans=-1;
//         while (start <= end) {
//             int mid = start + (end - start) / 2;
//             if (ar.get(mid) == tar) {
//                 ans = mid;
//                 break;
//             } else if (ar.get(mid) < tar) {
//                 start = mid + 1;
//             } else {
//                 ans = mid;
//                 end = mid - 1;
//             }
//         }
//         return ans;
//     }

//     public int lengthOfLIS(int[] nums) {
//         ArrayList<Integer> ar = new ArrayList<>();
//         ar.add(nums[0]);
//         int n = nums.length;
//         for (int i = 1; i < n; i++) {
//             if (ar.get(ar.size() - 1) < nums[i])
//                 ar.add(nums[i]);
//             else {
//                 int ans = helper(ar, 0, ar.size() - 1, nums[i]);
//                 ar.set(ans, nums[i]);
//             }
//         }
//         return ar.size();
//     }
//     void solve(int index,int [] nums,int prev,ArrayList<Integer> ans,int c)
//      { if(index==nums.length)
//       {
//         if(ans.size()==c)
//         t++;
//         return;
//       }
//       int take=0;
//       if(nums[index]>prev){
//         ans.add(nums[index]);
//       solve(index+1,nums,nums[index],ans,c);
//       ans.remove(ans.size()-1);
//       }
//         solve(index+1,nums,prev,ans,c);
//       }
//     public int findNumberOfLIS(int[] nums) {
//         ArrayList<Integer> ans=new ArrayList<>();
//      int a= lengthOfLIS(nums);
//      solve(0,nums,Integer.MIN_VALUE,ans,a);
//      return t;  
//     }
// }
   public int findNumberOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int[] count = new int[nums.length];
    int maxLength=0;
    for(int i=0;i<nums.length;i++) {
        dp[i]=1;
        count[i]=1;
        for(int j=0;j<i;j++) {
            if(nums[i]>nums[j]) {
              
                if(dp[i]<dp[j]+1) {
                    dp[i]=dp[j]+1;
                     count[i]=count[j];
                } else if(dp[i]==dp[j]+1) {
                    count[i]+=count[j];
                } 
            }
        }
        maxLength=Math.max(maxLength,dp[i]);
    }
    int ans=0;
    for(int i=0;i<dp.length;i++) {
        if(dp[i]==maxLength) {
            ans+=count[i];
        }
    }
    return ans;
}
}
