public class FinfFirstandLast {
    public int[] searchRange(int[] nums, int target) {
        int ar[]={-1,-1};
        if(nums.length==0)
        return ar;
        int start=0,end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
            {
                ar[0]=mid;
                end=mid-1;
            }
            else if(nums[mid]<target)
            start=mid+1;
            else
            end=mid-1;
        }
        start=0;end=nums.length-1;
         while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
            {
                ar[1]=mid;
                start=mid+1;
            }
            else if(nums[mid]<target)
            start=mid+1;
            else
            end=mid-1;
        }return ar;
     } 
}
