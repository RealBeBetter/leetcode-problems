package weekly.date2022.date202211.week321;

/**
 * 追加字符以获得子序列
 * 给你两个仅由小写英文字母组成的字符串 s 和 t 。
 * 现在需要通过向 s 末尾追加字符的方式使 t 变成 s 的一个 子序列 ，返回需要追加的最少字符数。
 * 子序列是一个可以由其他字符串删除部分（或不删除）字符但不改变剩下字符顺序得到的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "coaching", t = "coding"
 * 输出：4
 * 解释：向 s 末尾追加字符串 "ding" ，s = "coachingding" 。
 * 现在，t 是 s ("coachingding") 的一个子序列。
 * 可以证明向 s 末尾追加任何 3 个字符都无法使 t 成为 s 的一个子序列。
 * 示例 2：
 * 输入：s = "abcde", t = "a"
 * 输出：0
 * 解释：t 已经是 s ("abcde") 的一个子序列。
 * 示例 3：
 * 输入：s = "z", t = "abcde"
 * 输出：5
 * 解释：向 s 末尾追加字符串 "abcde" ，s = "zabcde" 。
 * 现在，t 是 s ("zabcde") 的一个子序列。
 * 可以证明向 s 末尾追加任何 4 个字符都无法使 t 成为 s 的一个子序列。
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 仅由小写英文字母组成
 *
 * @author Real
 * Date: 2022/11/27 11:01
 */
public class AppendCharactersToStringToMakeSubsequence {

    public static void main(String[] args) {
        AppendCharactersToStringToMakeSubsequence test = new AppendCharactersToStringToMakeSubsequence();
        System.out.println(test.appendCharacters("coaching", "coding"));
        System.out.println(test.appendCharacters("abcde", "a"));
        System.out.println(test.appendCharacters("z", "abcde"));
    }

    /**
     * 双指针，求出s中依次序包含t的位数还差多少
     * s + something，得到 target，t 为 target 的子序列，求 something 的长度
     *
     * @param s 源字符串
     * @param t 目标字符串
     * @return 还需要的长度
     */
    public int appendCharacters(String s, String t) {
        if (s == null || s.length() == 0) {
            return t == null ? 0 : t.length();
        }
        int target = 0;
        int length = s.length();
        int targetLength = t.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == t.charAt(target)) {
                if (target + 1 == targetLength) {
                    target++;
                    break;
                }
                target++;
            }
        }
        return targetLength - target;
    }

}
