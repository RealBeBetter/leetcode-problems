package plan.window;

import java.util.LinkedList;

/**
 * @author Real
 * @since 2023/3/11 13:28
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 无重复最长子串长度
     *
     * @param str str
     * @return int
     */
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int ans = 0;
        LinkedList<Character> linkedList = new LinkedList<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            while (linkedList.contains(c)) {
                linkedList.removeFirst();
            }
            linkedList.add(c);
            ans = Math.max(linkedList.size(), ans);
        }

        return ans;
    }

}
