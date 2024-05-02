public class jumpGames2 {
    public int jump(int[] nums) {
        int ri=0,rs=0,step=0;
        if(nums.length==1)
        return 0;
        for(int i=0;i<nums.length;i++)
        {
          ri=Math.max(ri,i+nums[i]);
          if(i==rs)
          {
              step++;
              rs=ri;
          }
          if(rs>=nums.length-1)
          return step;
        } return step;
     }
 }
 

