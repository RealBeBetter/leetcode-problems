package weekly.date2022.date202212.week325;

/**
 * 6270. 每种字符至少取 K 个
 * 给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。
 * 每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
 * 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：s = "aabaaaacaabc", k = 2
 * 输出：8
 * 解释：
 * 从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
 * 从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
 * 共需要 3 + 5 = 8 分钟。
 * 可以证明需要的最少分钟数是 8 。
 * 示例 2：
 * 输入：s = "a", k = 1
 * 输出：-1
 * 解释：无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s 仅由字母 'a'、'b'、'c' 组成
 * 0 <= k <= s.length
 *
 * @author Real
 * @since 2022/12/25 11:11
 */
public class TakeKofEachCharacterFromLeftAndRight {

    /**
     * 取走字符的次数，至少取到 a/b/c 各 k 个
     *
     * @param s 目标字符串
     * @param k 目标个数
     * @return int
     */
    public int takeCharacters(String s, int k) {
        int left = 0, right = s.length() - 1, min = 0;
        int[] map = new int[3];
        for (; left < s.length() && map[0] < k | map[1] < k | map[2] < k; min = ++left) {
            map[s.charAt(left) - 'a']++;
        }
        for (; left > 0; min = Math.min(min, s.length() - right + left - 1)) {
            for (map[s.charAt(--left) - 'a']--; right >= 0 && map[s.charAt(left) - 'a'] < k; right--) {
                map[s.charAt(right) - 'a']++;
            }
        }
        return map[0] < k | map[1] < k | map[2] < k ? -1 : min;
    }

}
