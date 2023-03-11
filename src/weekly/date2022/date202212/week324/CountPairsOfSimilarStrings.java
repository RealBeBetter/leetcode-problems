package weekly.date2022.date202212.week324;

import java.util.*;

/**
 * 6265. 统计相似字符串对的数目
 * 给你一个下标从 0 开始的字符串数组 words 。
 * 如果两个字符串由相同的字符组成，则认为这两个字符串 相似 。
 * 例如，"abca" 和 "cba" 相似，因为它们都由字符 'a'、'b'、'c' 组成。
 * 然而，"abacba" 和 "bcfd" 不相似，因为它们不是相同字符组成的。
 * 请你找出满足字符串 words[i] 和 words[j] 相似的下标对 (i, j) ，并返回下标对的数目，
 * 其中 0 <= i < j <= word.length - 1 。
 * <p>
 * 示例 1：
 * 输入：words = ["aba","aabb","abcd","bac","aabc"]
 * 输出：2
 * 解释：共有 2 对满足条件：
 * - i = 0 且 j = 1 ：words[0] 和 words[1] 只由字符 'a' 和 'b' 组成。
 * - i = 3 且 j = 4 ：words[3] 和 words[4] 只由字符 'a'、'b' 和 'c' 。
 * 示例 2：
 * 输入：words = ["aabb","ab","ba"]
 * 输出：3
 * 解释：共有 3 对满足条件：
 * - i = 0 且 j = 1 ：words[0] 和 words[1] 只由字符 'a' 和 'b' 组成。
 * - i = 0 且 j = 2 ：words[0] 和 words[2] 只由字符 'a' 和 'b' 组成。
 * - i = 1 且 j = 2 ：words[1] 和 words[2] 只由字符 'a' 和 'b' 组成。
 * 示例 3：
 * 输入：words = ["nba","cba","dba"]
 * 输出：0
 * 解释：不存在满足条件的下标对，返回 0 。
 * <p>
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 仅由小写英文字母组成
 *
 * @author Real
 * @since 2022/12/18 11:03
 */
public class CountPairsOfSimilarStrings {

    public static void main(String[] args) {
        CountPairsOfSimilarStrings test = new CountPairsOfSimilarStrings();
        String[] array = {"aba", "aabb", "abcd", "bac", "aabc"};
        System.out.println(test.similarPairs(array));
    }

    public int similarPairs(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int length = words.length;
        double capacity = length / 0.75 + 1;
        Map<String, Integer> map = new HashMap<>((int) capacity);
        for (String word : words) {
            int len = word.length();
            for (int j = 0; j < len; j++) {
                set.add(word.charAt(j));
            }
            String noRepeatChar = Arrays.toString(set.toArray());
            map.merge(noRepeatChar, 1, Integer::sum);
            set.clear();
        }
        int count = 0;
        // 统计 map 的 Key 是否存在 >= 2 的元素。
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value >= 2) {
                count += combined(value);
            }
        }
        return count;
    }

    public static int combined(int n) {
        if (n > 1) {
            return (n - 1) + combined(n - 1);
        }
        return 0;
    }

    private final Set<Character> set = new TreeSet<>(new Comparator<Character>() {
        @Override
        public int compare(Character o1, Character o2) {
            return o1 - o2;
        }
    });

}
