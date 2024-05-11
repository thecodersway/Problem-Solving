public class Decodeways1 {
    //https://leetcode.com/problems/decode-ways/
  //        int rec(String s, int i, int[] dp) {
//         if (i == s.length()) {
//             return 1;
//         }
        
//         if (s.charAt(i) == '0') {
//             return 0;
//         }
        
//         if (dp[i] != -1) {
//             return dp[i];
//         }

//         int one = rec(s, i + 1, dp);
//         int two = 0;

//         if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
//             two = rec(s, i + 2, dp);
//         }
//          dp[i] = one + two;
//         return dp[i];
//     }
//     public int numDecodings(String s) {
//      int dp[]=new int[s.length()];
//      Arrays.fill(dp,-1);
//      return rec(s,0,dp);   
//     }
// }dp[i] represents number of ways yo decode the substring till i
public int numDecodings(String s) {
    int dp[] = new int[s.length() +1];
    dp[0]=1;
    dp[1]= s.charAt(0) == '0' ? 0 : 1;
    for(int i=2; i<=s.length(); i++){
        int oneDigit = Integer.valueOf(s.substring(i-1,i));
        int twoDigits = Integer.valueOf(s.substring(i-2,i));
        if(oneDigit >=1){
            dp[i]+=dp[i-1];
        }
        if(twoDigits >=10 && twoDigits<=26){
            dp[i]+=dp[i-2];
        }
        
    }
return dp[s.length()];
}
}