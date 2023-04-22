package leetcode75.str;

/**
 * 151. 反转字符串中的单词
 *
 * @author Real
 * @since 2023/4/22 19:57
 */
public class ReverseWordsString {

    public static void main(String[] args) {
        ReverseWordsString test = new ReverseWordsString();
        String words = test.reverseWords("  hello world  ");
        System.out.println(words);
    }

    public String reverseWords(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = length - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (!word.toString().isEmpty()) {
                    sb.append(word.reverse()).append(c);
                    word = new StringBuilder();
                }
            } else {
                word.append(c);
            }
        }

        if (!word.toString().isEmpty()) {
            sb.append(word.reverse());
        }

        char lastChar = sb.charAt(sb.length() - 1);
        if (lastChar == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

}
