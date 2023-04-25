package leetcode75.slide;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1456. 定长子串中元音的最大数目
 *
 * @author Real
 * @since 2023/4/25 23:12
 */
public class MaximumNumberVowels {

    public int maxVowels(String s, int k) {
        Character[] characters = {'a', 'e', 'i', 'o', 'u'};
        List<Character> vowels = Arrays.stream(characters).collect(Collectors.toList());

        char[] chars = s.toCharArray();
        int maxVowels = 0, vowelCount = 0, pointer = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(chars[i])) {
                vowelCount++;
            }
        }

        for (int i = k; i < chars.length; i++) {
            maxVowels = Math.max(vowelCount, maxVowels);
            if (vowels.contains(chars[i])) {
                vowelCount++;
            }

            if (vowels.contains(chars[pointer++])) {
                vowelCount--;
            }
        }

        return Math.max(vowelCount, maxVowels);
    }

}
