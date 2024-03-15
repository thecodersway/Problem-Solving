import java.util.*;

public class LunchBoxes {
    /*
     * Deepthi loves cruises. She is going to visit the Caribbean on a Cruise. So,
     * she thought of providing everyone who is traveling with her with lunch as
     * well.
     * Each food item is denoted by an integer ID. A lunch box contains exactly A
     * food items.
     * She has a list of food items with her denoted by an integer array B. She
     * asked you
     * to tell her the maximum number of lunchboxes she can prepare.
     * 
     * Note:
     * A lunch box can contain multiple same kinds of food items but
     * the content of each lunch box should be the same.
     * Example Input
     * Input 1:
     * A = 3, B = [1, 2, 3, 2, 6, 1, 3]
     * Input 2:
     * A = 4, B = [1, 3, 1, 3, 10, 3, 6, 6, 13]
     * Example Output
     * Output 1:
     * 2
     * Output 2:
     * 1
     */
    public static void main(String[] args) {
       int a= bin(new int[] {1, 2, 3, 2, 6, 1, 3}, 3);
       System.out.println(a);
    }

    static int bin(int ar[], int k) {
        int start = 0, end = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (!map.containsKey(ar[i]))
                map.put(ar[i], 1);
            else
                map.put(ar[i], map.get(ar[i]) + 1);
            end = Math.max(end, map.get(ar[i]));
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (blackbox(map, mid, k)) {
                ans = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return ans;
    }

static boolean blackbox(HashMap<Integer,Integer> map,int mid,int k)
{    int ans=0;
    for(Map.Entry<Integer,Integer> m:map.entrySet())
    {
        int p=m.getValue()/mid;
        ans+=p;
    }
    return ans>=k;
}
}
