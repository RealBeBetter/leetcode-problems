package leetcode75.hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1657. 确定两个字符串是否接近
 *
 * @author wei.song
 * @since 2023/4/29 13:34
 */
public class DetermineTwoStringsAreClose {

    public static void main(String[] args) {
        DetermineTwoStringsAreClose test = new DetermineTwoStringsAreClose();
        System.out.println(test.closeStrings("a", "aa"));
        System.out.println(test.closeStrings("abc", "bca"));
        System.out.println(test.closeStrings("cabbba", "abbccc"));
        System.out.println(test.closeStrings("cabbba", "aabbss"));
    }

    /**
     * 判断两个字符串是否相似
     *
     * @param word1 word1
     * @param word2 word2
     * @return boolean
     */
    public boolean closeStrings(String word1, String word2) {
        // 判断两个字符串的数量是否相等，元素相等，且数量排序之后相等
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 != length2) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>((int) (length1 / 0.75 + 1));
        Map<Character, Integer> map2 = new HashMap<>((int) (length1 / 0.75 + 1));
        for (int i = 0; i < length1; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            map1.compute(c1, (k, v) -> v = v == null ? 1 : v + 1);
            map2.compute(c2, (k, v) -> v = v == null ? 1 : v + 1);
        }

        Set<Character> characters1 = map1.keySet().stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Character> characters2 = map2.keySet().stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        if (!characters1.toString().equals(characters2.toString())) {
            return false;
        }

        List<Integer> values1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> values2 = map2.values().stream().sorted().collect(Collectors.toList());

        return values1.toString().equals(values2.toString());
    }

}
