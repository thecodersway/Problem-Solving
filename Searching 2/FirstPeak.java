class FirstPeak{
    public static void main(String[] args) {
       int a=findPeakElement(new int[]{2,6,4,2}); 
       System.out.println(a);
    }
public static int findPeakElement(int[] nums) {
    int start=0,end=nums.length-1;
    int mid=0;
    if(nums.length==1)
    return 0;
    if(nums[0]>nums[1])
    return 0;
    if(nums[end]>nums[end-1])
    return end;
    while(start<=end)
    {
    mid=start+(end-start)/2;
    if(mid>0&&mid<nums.length-1&&nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1])
    return mid;
    else if(mid<nums.length-1&&nums[mid]>nums[mid+1])
    end=mid-1;
    else
    start=mid+1;
    } return mid;
  }
}