package leetcode75.pointer;

/**
 * 392. 判断子序列
 *
 * @author Real
 * @since 2023/4/25 22:34
 */
public class IsSubsequence {

    /**
     * 是否为子序列，判断 s 是否为 t 的子序列
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return boolean
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        int pointer = 0;
        int length = t.length();
        for (int i = 0; i < length; i++) {
            // 注意中途满足的情况
            if (pointer == s.length()) {
                return true;
            }

            if (s.charAt(pointer) == t.charAt(i)) {
                pointer++;
            }
        }

        return pointer == s.length();
    }

}
