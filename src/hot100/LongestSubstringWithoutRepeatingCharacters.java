package hot100;

import java.util.LinkedList;
import java.util.List;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @author Real
 * Date: 2022/11/30 22:22
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 无重复字符最长子串
     * 维护一个变长链表，得到每一种子串情况，对比得到最长的子串
     *
     * @param str 字符串
     * @return 最长长度
     */
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int res = 0;
        List<Character> list = new LinkedList<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            while (list.contains(aChar)) {
                list.remove(0);
            }
            list.add(aChar);
            res = Math.max(res, list.size());
        }
        return res;
    }

}
