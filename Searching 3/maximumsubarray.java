import java.util.*;
class maximumsubarray
{
  public static void main(String args[])
  {
    int a=bin(new int[]{1,3,4,2},7);
    System.out.println(a);

  }
  static boolean blackbox(int ar[],int mid,int k)
  {int sum=0;
    for(int i=0;i<mid;i++)
    {
     sum+=ar[i];
    }
    int j=0;
    if(sum>k)return false;
    for(int i=mid;i<ar.length;i++)
    {
      sum-=ar[j];
      j++;
      sum+=ar[i];
      if(sum>k)
      return false;
    }return true;
  }
  static int bin(int ar[],int k)
  { int ans=0;
    int start=1;
    int end=ar.length-1;
    while(start<=end)
    {
        int mid=start+(end-start)/2;
        if(blackbox(ar,mid,k))
        {
           ans=mid;
           start=mid+1; 
        }
        else
        end=mid-1;
    }return ans;
  }
}
