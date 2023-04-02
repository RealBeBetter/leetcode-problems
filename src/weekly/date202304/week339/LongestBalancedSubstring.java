package weekly.date202304.week339;

/**
 * 6362. 最长平衡子字符串
 *
 * @author Real
 * @since 2023/4/2 10:28
 */
public class LongestBalancedSubstring {

    public static void main(String[] args) {
        LongestBalancedSubstring test = new LongestBalancedSubstring();
        String a = "01000111";
        String b = "0011";
        String c = "111";
        String d = "101";
        System.out.println(test.findTheLongestBalancedSubstring(a));
        System.out.println(test.findTheLongestBalancedSubstring(b));
        System.out.println(test.findTheLongestBalancedSubstring(c));
        System.out.println(test.findTheLongestBalancedSubstring(d));
    }

    public int findTheLongestBalancedSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        // 最长平衡子串
        int zeroCount = 0;
        int ontCount = 0;
        int ans = 0;
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            zeroCount++;
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == '1' && chars[i] == '0') {
                zeroCount = 1;
                ontCount = 0;
                continue;
            }

            if (chars[i] == '0') {
                zeroCount++;
            } else {
                ontCount++;
            }

            int currentCount = Math.min(zeroCount, ontCount) * 2;
            ans = Math.max(ans, currentCount);
        }

        return ans;
    }

}
