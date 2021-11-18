package T1_500;

import java.util.LinkedList;

/**
 * @ author : Real
 * @ date : 2021/10/27 17:02
 * @ description : 最长无重复子串——3
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char aChar : chars) {
            if (linkedList.contains(aChar)) {
                int temp = linkedList.indexOf(aChar);
                while (temp-- >= 0) {
                    linkedList.removeFirst();
                }
            }
            linkedList.add(aChar);
            maxLength = Math.max(linkedList.size(), maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }


}
