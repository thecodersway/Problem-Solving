public class KsmallestElementMatrix {
    //https://www.geeksforgeeks.org/problems/kth-element-in-matrix/1
       static int count(int[] ar,int midd)
    {
        int start=0;
        int end=ar.length-1;
        int ans=0;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(ar[mid]<midd)
            {
                ans=mid+1;
             start=mid+1;}
             else
             end=mid-1;
        }return ans;
    }
    static boolean blackbox(int[][] ar,int mid,int m)
    { int c=0;
        for(int i=0;i<ar.length;i++)
        {
          c+=count(ar[i],mid);  
        }
        return c<=m;
    }
    
	public static int kthSmallest(int[][]A,int n,int k)
	{
      
         int start=A[0][0];
        int end=A[n-1][n-1];

        int ans=0;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(blackbox(A,mid,k-1))
            {
                ans=mid;
                start=mid+1;
            }else
            end=mid-1;
        }return ans;
    }
    }


