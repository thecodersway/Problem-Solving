class Solution {
   static int pivot(int[] ar)
    {
        int start=0;
        int end=ar.length-1;
        while(start<=end)
    {
        int mid=start+(end-start)/2;
        if(mid>start && ar[mid]<ar[mid-1])
        return mid -1;
        else if(mid<end&&ar[mid]>ar[mid+1])
        return mid;
        else if(ar[start]<ar[mid])
        start=mid+1;
        else
        end=mid-1;

    }return -1;
    }
   static int bin(int ar[],int start,int end,int tar)
    {
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(ar[mid]==tar)
            return mid;
            else if(ar[mid]>tar)
            end=mid-1;
            else
            start=mid+1;
        }return -1;

    }
    public static int search(int[] nums, int target) {
       int pivot=pivot(nums);
       System.out.println(pivot);
       if(pivot==-1)
       return bin(nums,0,nums.length-1,target);
       if(nums[pivot]==target)
       return pivot;
       if(nums[0]<=target)
       
        return bin(nums,0,pivot-1,target); 
         return bin(nums,pivot+1,nums.length-1,target);
    }
    public static void main(String[] args) {
        int ar[]={1,2,3,4,5,6};
        int target=2;
        search(ar,target);
    }
}