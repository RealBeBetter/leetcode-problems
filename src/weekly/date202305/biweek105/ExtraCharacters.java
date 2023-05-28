package weekly.date202305.biweek105;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 6394. 字符串中的额外字符
 *
 * @author Real
 * @since 2023/5/27 22:39
 */
public class ExtraCharacters {

    public int minExtraChar(String s, String[] dictionary) {
        int length = s.length();
        int[] dp = new int[length + 1];
        List<String> dict = Arrays.stream(dictionary).distinct().collect(Collectors.toList());

        for (int i = 1; i <= length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dict.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[length];
    }

}
