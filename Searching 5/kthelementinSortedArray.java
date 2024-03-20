//https://www.codingninjas.com/studio/problems/k-th-element-of-2-sorted-array_1164159?leftPanelTabValue=PROBLEM

import java.util.ArrayList;

class kthelementinSortedArray
{
     public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
        if(n>m)
         return  kthElement( arr2,  arr1, m, n, k);
        int start=Math.max(0,k-m);
        int end=Math.min(n,k);
         while(start<=end)
         {
             int mid1=start+(end-start)/2;
             int mid2=k-mid1;
             int left1=(mid1<=0)?Integer.MIN_VALUE:arr1.get(mid1-1);
             int left2=(mid2<=0)?Integer.MIN_VALUE:arr2.get(mid2-1);
             int right1=(mid1>=n)?Integer.MAX_VALUE:arr1.get(mid1);
             int right2=(mid2>=m)?Integer.MAX_VALUE:arr2.get(mid2);
              if(left1<=right2&&left2<=right1)
              {
                    return Math.max(left1,left2);
              }
              else if(left1>right2)
              end=mid1-1;
              else
              start=mid1+1;
         }

        return 0;
    }
}