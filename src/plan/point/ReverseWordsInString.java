package plan.point;

/**
 * @author Real
 * @since 2023/3/4 23:39
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
    }

    /**
     * 反转单词
     *
     * @param s 字符串
     * @return {@link String}
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int length = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                end = i - 1;
                s = reverse(s, start, end);
                start = i + 1;
            }
        }

        return reverse(s, start, length - 1);
    }

    private String reverse(String str, int start, int end) {
        char[] s = str.toCharArray();
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        return String.copyValueOf(s);
    }

}
