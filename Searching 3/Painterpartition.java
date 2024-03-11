import java.util.ArrayList;

public class Painterpartition {
    //https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557
    static boolean ispossible(int mintime,ArrayList<Integer> boards,int n,int k)
 {
     int ans=1;
     int sum=0;
     for(int i=0;i<n;i++)
     {
         sum+=boards.get(i);
         if(sum>mintime)
         {
             ans++;
             sum=boards.get(i);
         }
     }return(ans<=k);

 }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        if(k>boards.size())
        return -1;
        int sum=0;
        int max=0;
       for(int i=0;i<boards.size();i++)
     {   max=Math.max(max,boards.get(i));
         sum+=boards.get(i);
         
     }
        int start=max, end=sum;
        int ans=-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(ispossible( mid,boards,boards.size(),k))
            {
                ans=mid;
              end=mid-1;

            }
            else
            start=mid+1;
        }return ans;
    }

}
