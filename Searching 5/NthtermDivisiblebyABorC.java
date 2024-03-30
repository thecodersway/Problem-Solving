public class NthtermDivisiblebyABorC {
    static int gcd(int a,int b)
    {
        if(b==0)
        return a;
        return gcd(b,a%b);
    }
    static int lcm(int a,int b)
    {
        return ((a*b)/gcd(a,b));
    }
    static boolean blackbox(int a,int b,int c,int mid,int k)
    {
        int d=mid/a+mid/b+mid/c-mid/lcm(a,b)-mid/lcm(b,c)-mid/lcm(a,c)+mid/(lcm(lcm(a,b),c));
        return d>=k;
    }
   static int bin(int a,int b,int c,int k)
    {
        int start=0;
        int end=Integer.MAX_VALUE;
        int ans=0;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(blackbox(a,b,c,mid,k))
            {
                ans=mid;
               end=mid-1;
            }
            else
           start=mid+1;
         }return ans;
    }
    public static void main(String[] args) {
      int a= bin(2,3,5,10);
      System.out.println(a);
    }
}
