public class substringmaxcost 
 {
        public int equalSubstring(String s, String t, int maxCost) {
            int i=0,j=0;
            int ans=0,max=0;int c=0;
            for(i=0;i<s.length();i++)
            {
                ans+=Math.abs(s.charAt(i)-t.charAt(i));
                c++;
                while(ans>maxCost)
                {
                   ans-=Math.abs(s.charAt(j)-t.charAt(j));
                   j++;
                   c--;
                }
               max=Math.max(c,max); 
            }return max;
        }
    }
