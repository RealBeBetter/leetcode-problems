package weekly_competition.date2023.date202302.week334;

/**
 * 6368. 找出字符串的可整除数组
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 * <p>
 * 示例 1：
 * 输入：word = "998244353", m = 3
 * 输出：[1,1,0,0,0,1,1,0,0]
 * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
 * 示例 2：
 * 输入：word = "1010", m = 10
 * 输出：[0,1,0,1]
 * 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
 * <p>
 * 提示：
 * 1 <= n <= 105
 * word.length == n
 * word 由数字 0 到 9 组成
 * 1 <= m <= 109
 *
 * @author Real
 * @since 2023/2/26 10:45
 */
public class FindDivisibilityArrayOfString {

    public static void main(String[] args) {
    }

    /**
     * 前缀能被给定数字整除的index数组
     *
     * @param word 字符串
     * @param m    数字
     * @return {@link int[]}
     */
    public static int[] divisibilityArray(String word, int m) {
        if (word == null || word.length() == 0) {
            return null;
        }

        int length = word.length();
        int[] ans = new int[length];
        long[] currentMod = new long[length + 1];
        currentMod[0] = Integer.parseInt(String.valueOf(word.charAt(0))) % m;
        ans[0] = currentMod[0] == 0 ? 1 : 0;

        for (int i = 1; i < length; i++) {
            long num = currentMod[i - 1] * 10 + Integer.parseInt(String.valueOf(word.charAt(i)));
            currentMod[i] = num % m;
            ans[i] = currentMod[i] == 0 ? 1 : 0;
        }

        return ans;
    }

}
