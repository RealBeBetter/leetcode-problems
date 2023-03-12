package weekly.date202303.week336;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Real
 * @since 2023/3/12 10:32
 */
public class CountNumberVowelStrings {

    /**
     * 统计范围内的元音字符串个数
     *
     * @param words 单词
     * @param left  左下标
     * @param right 右下标
     * @return int
     */
    public int vowelStrings(String[] words, int left, int right) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int ans = 0;
        Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
        List<Character> list = Arrays.stream(vowels).collect(Collectors.toList());

        int length = words.length;
        left = Math.max(left, 0);
        right = Math.min(right, length - 1);
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (list.contains(word.charAt(0)) && list.contains(word.charAt(word.length() - 1))) {
                ans++;
            }
        }

        return ans;
    }

}
