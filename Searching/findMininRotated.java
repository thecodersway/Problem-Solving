public class findMininRotated {
    int pivot(int ar[])
    {
        int start=0;
        int end=ar.length-1;
        while(start<=end)
      {
          int mid=start+(end-start)/2;
          if(mid>start&&ar[mid]<ar[mid-1])
          return mid-1;
          if(mid<end&&ar[mid]>ar[mid+1])
          return mid;
          else if(ar[mid]>ar[start])
          start=mid+1;
          else
          end=mid-1;
      }return -1;
    }
    public int findMin(int[] nums) {
        int pivot=pivot(nums);
        return nums[pivot+1];
    }
}

