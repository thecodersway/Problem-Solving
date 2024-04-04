
public class eachBSThasInternalNodeONE {
    public static void main(String args[])
    {
        int ar[]={9,6,4,8,2,10};
       // 8, 3, 5, 7, 6
        //20, 10, 11, 13, 12
        //100, 10, 11, 13, 12
        boolean b=helper(ar);
        System.out.println(b);
    }
    static boolean helper(int ar[])
    {
      for(int i=0;i<ar.length-1;i++)
      {
        if(ar[i]>ar[i+1]&&ar[i]<ar[ar.length-1]||ar[i]<ar[i+1]&&ar[i]>ar[ar.length-1])
                   return false;
      }
      return true;
    }
}
