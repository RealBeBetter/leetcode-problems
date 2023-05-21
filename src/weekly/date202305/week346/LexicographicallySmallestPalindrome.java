package weekly.date202305.week346;

/**
 * 6454. 字典序最小回文串
 *
 * @author Real
 * @since 2023/5/21 10:49
 */
public class LexicographicallySmallestPalindrome {

    public static void main(String[] args) {
        LexicographicallySmallestPalindrome test = new LexicographicallySmallestPalindrome();
        System.out.println(test.makeSmallestPalindrome("egcfe"));
        System.out.println(test.makeSmallestPalindrome("abba"));
    }

    public String makeSmallestPalindrome(String s) {
        // 返回更改之后的最小回文串
        int length = s.length();
        StringBuilder positive = new StringBuilder();
        StringBuilder negative = new StringBuilder();
        for (int i = 0, j = length - 1; i < length / 2 && j >= length / 2; i++, j--) {
            positive.append(s.charAt(i));
            negative.append(s.charAt(j));
        }

        String s1 = positive.toString();
        String s2 = negative.toString();
        StringBuilder temp = new StringBuilder();
        int halfLength = s1.length();
        for (int i = 0; i < halfLength; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 < c2) {
                temp.append(c1);
            } else {
                temp.append(c2);
            }
        }

        StringBuilder ans = new StringBuilder(temp);
        if (length % 2 == 1) {
            ans.append(s.charAt(length / 2));
        }
        ans.append(temp.reverse());
        return ans.toString();
    }

}
