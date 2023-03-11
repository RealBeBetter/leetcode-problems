package plan.window;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Real
 * @since 2023/3/11 13:38
 */
public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString test = new PermutationInString();
        String s1 = "prosperity";
        String s2 = "properties";
        System.out.println(test.checkInclusion(s1, s2));
    }

    /**
     * 判断 s2 是否包含 s1 的排列，只需要判断各字母的个数是否相等
     *
     * @param s1 s1
     * @param s2 s2
     * @return boolean
     */
    public boolean checkInclusion(String s1, String s2) {
        // 已经限制了字符串长度不为 0
        int length = s2.length();
        int subStringLength = s1.length();
        if (subStringLength > length) {
            return false;
        }

        Map<Character, Integer> alphabetCountMap = new LinkedHashMap<>();
        char[] chars = s1.toCharArray();
        for (char c : chars) {
            alphabetCountMap.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> slidingWindowMap = new LinkedHashMap<>();
        for (int i = 0, j = i + subStringLength; i < length && j <= length; i++, j++) {
            String substring = s2.substring(i, j);
            if (i == 0) {
                char[] charArray = substring.toCharArray();
                for (char c : charArray) {
                    slidingWindowMap.merge(c, 1, Integer::sum);
                }
            } else {
                char removedKey = s2.charAt(i - 1);
                if (slidingWindowMap.containsKey(removedKey)) {
                    if (slidingWindowMap.get(removedKey) == 1) {
                        slidingWindowMap.remove(removedKey);
                    } else {
                        slidingWindowMap.put(removedKey, slidingWindowMap.get(removedKey) - 1);
                    }
                }
                slidingWindowMap.merge(s2.charAt(j - 1), 1, Integer::sum);
            }
            if (alphabetCountMap.equals(slidingWindowMap)) {
                return true;
            }
        }

        return false;
    }

}
