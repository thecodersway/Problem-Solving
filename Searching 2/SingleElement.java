public class SingleElement {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4}));
    }
    //https://leetcode.com/problems/single-element-in-a-sorted-array/description/
    public static int singleNonDuplicate(int[] nums) {
        int start=0,end=nums.length-1;
        if(nums.length==1)
        return nums[0];
        if(nums[0]!=nums[1])
        return nums[0];
        if(nums[end-1]!=nums[end])
        return nums[end];
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid>0&&mid<nums.length-1&&nums[mid]!=nums[mid+1]&&nums[mid]!=nums[mid-1])
            return nums[mid];
            else if(mid%2==0)
            {
                if(mid<nums.length-1&&nums[mid]==nums[mid+1])
                start=mid+1;
                else
                end=mid-1;
            }
            else
            {
                 if(nums[mid]==nums[mid-1])
                start=mid+1;
                else
                end=mid-1;
            }
        } return -1;
     }
}
