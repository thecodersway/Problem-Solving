import java.util.ArrayList;
//https://www.interviewbit.com/problems/matrix-median/
public class matrixMedian {
    static int count(ArrayList<Integer> ar,int midd)
    {
        int start=0;
        int end=ar.size()-1;
        int ans=0;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(ar.get(mid)<midd)
            {
                ans=mid+1;
             start=mid+1;}
             else
             end=mid-1;
        }return ans;
    }
    static boolean blackbox(ArrayList<ArrayList<Integer>> ar,int mid,int m)
    { int c=0;
        for(int i=0;i<ar.size();i++)
        {
          c+=count(ar.get(i),mid);  
        }
        return c<=m;
    }
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n=A.size();
        int m=A.get(0).size();
         int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            start=Math.min(start,A.get(i).get(0));
            end=Math.max(end,A.get(i).get(m-1));
        }
        int k=(n*m)/2;
       
        int ans=0;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(blackbox(A,mid,k))
            {
                ans=mid;
                start=mid+1;
            }else
            end=mid-1;
        }return ans;
    }
}


