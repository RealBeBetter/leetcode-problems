package problems.leet1_500;

/**
 * @ author : Real
 * @ date : 2021/10/27 17:10
 * @ description :
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring_5 {
    public static String longestPalindrome(String s) {
        // 求最长回文子串，应该反向求解，即按照字符串的长度递减至一个
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }

        int max = 1;
        int begin = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                // 剪枝操作，先判断长度是否大于当前最大长度再进行回文判断
                if (j - i + 1 > max && isPalindrome(chars, i, j)) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    public static boolean isPalindrome(char[] chars, int left, int right) {
        // 写一个判断是否是回文字符串的方法
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
        String special = "aa";
        System.out.println(longestPalindrome(s));
    }
}
