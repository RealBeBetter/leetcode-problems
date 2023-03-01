package problems.T1001_1500;

/**
 * @ author : Real
 * @ date : 2021/10/28 2:43
 * @ description : 删除回文子序列
 * 给你一个字符串s，它仅由字母'a' 和 'b'组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，
 * 那么这个字符串就是原字符串的一个子序列。
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 * 示例 1：
 * 输入：s = "ababa"
 * 输出：1
 * 解释：字符串本身就是回文序列，只需要删除一次。
 * 示例 2：
 * 输入：s = "abb"
 * 输出：2
 * 解释："abb" -> "bb" -> "".
 * 先删除回文子序列 "a"，然后再删除 "bb"。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-palindromic-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemovePalindromicSubsequences_1332 {
    public static int removePalindromeSub(String s) {
        // 因为只包含两个字母，所以最多次数只有2
        // 为空，0次
        if (s.length() == 0) {
            return 0;
        }
        // 回文，一次；非回文，两次
        if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }
    public static boolean isPalindrome (String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
