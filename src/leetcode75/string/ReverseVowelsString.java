package leetcode75.string;

import java.util.Arrays;
import java.util.List;

/**
 * 345. 反转字符串中的元音字母
 *
 * @author Real
 * @since 2023/4/22 19:35
 */
public class ReverseVowelsString {

    public String reverseVowels(String str) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int length = str.length();
        char[] charArray = str.toCharArray();
        for (int i = 0, j = length - 1; i < j; ) {
            char left = charArray[i];
            char right = charArray[j];
            boolean containsLeft = vowels.contains(left);
            boolean containsRight = vowels.contains(right);
            if (containsLeft && containsRight) {
                charArray[i++] = right;
                charArray[j--] = left;
            } else if (containsLeft) {
                j--;
            } else if (containsRight) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(c);
        }

        return sb.toString();
    }

}
