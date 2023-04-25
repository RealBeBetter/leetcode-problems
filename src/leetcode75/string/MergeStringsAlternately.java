package leetcode75.string;

/**
 * 1768. 交替合并字符串
 *
 * @author Real
 * @since 2023/4/21 23:01
 */
public class MergeStringsAlternately {

    /**
     * 从 word1 开始，通过交替添加字母来合并字符串
     *
     * @param word1 word1
     * @param word2 word2
     * @return {@link String}
     */
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0, index2 = 0;
        int length1 = word1.length(), length2 = word2.length();

        StringBuilder ans = new StringBuilder();

        while (index1 < length1 && index2 < length2) {
            ans.append(word1.charAt(index1++));
            ans.append(word2.charAt(index2++));
        }
        if (index1 < length1) {
            ans.append(word1.substring(index1));
        }
        if (index2 < length2) {
            ans.append(word2.substring(index2));
        }

        return ans.toString();
    }

}
