package T1_500;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author : Real
 * @ date : 2021/10/27 16:32
 * @ description :
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidAnagram_242 {
    public static boolean isAnagram(String s, String t) {
        // 第一种思路就是利用Map进行统计
        // 第二种思路就是将两个字符串排序，之后equals进行比较
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(chars.length);
        for (char aChar : chars) {
            if (map.get(aChar) == null) {
                map.put(aChar, 1);
            } else {
                map.put(aChar, map.get(aChar) + 1);
            }
        }

        char[] charArray = t.toCharArray();
        for (char c : charArray) {
            if (map.get(c) != null) {
                // 如果存在该键，则将数量-1
                Integer integer = map.get(c);
                integer--;
                map.put(c, integer);
            } else {
                return false;
            }
        }
        int flag = 0;
        for (Character character : map.keySet()) {
            if (map.get(character) != 0) {
                flag = 1;
                break;
            }
        }

        return flag == 0;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
