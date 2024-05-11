public class Decodeways2 {
    static final int MOD = 1000000007;

    public int numDecodings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        long prevPrev = 0;
        long prev = 1;
        long current = 0;

        for (int i = 1; i <= n; i++) {
            char currentChar = chars[i - 1];
            long waysSingleDigit = 0;
            long waysTwoDigits = 0;

            if (currentChar == '*') {
                waysSingleDigit = 9 * prev % MOD;
            } else if (currentChar != '0') {
                waysSingleDigit = prev;
            } else {
                waysSingleDigit = 0;
            }

            if (i > 1) {
                char prevChar = chars[i - 2];

                if (prevChar == '*' && currentChar == '*') {
                    waysTwoDigits = (waysTwoDigits + 15 * prevPrev) % MOD;
                } else if (prevChar == '*') {
                    if (currentChar > '6') {
                        waysTwoDigits = (waysTwoDigits + prevPrev) % MOD;
                    } else {
                        waysTwoDigits = (waysTwoDigits + 2 * prevPrev) % MOD;
                    }
                } else if (currentChar == '*') {
                    if (prevChar == '1') {
                        waysTwoDigits = (waysTwoDigits + 9 * prevPrev) % MOD;
                    } else if (prevChar == '2') {
                        waysTwoDigits = (waysTwoDigits + 6 * prevPrev) % MOD;
                    }
                } else if (prevChar != '0' && (prevChar - '0') * 10 + currentChar - '0' <= 26) {
                    waysTwoDigits = (waysTwoDigits + prevPrev) % MOD;
                }
            }

            current = (waysSingleDigit + waysTwoDigits) % MOD;
            prevPrev = prev;
            prev = current;
        }

        return (int) current;
    }
}
