package weekly.date202305.biweek105;

import java.util.Arrays;
import java.util.List;

/**
 * 6394. 字符串中的额外字符
 *
 * @author Real
 * @since 2023/5/27 22:39
 */
public class ExtraCharacters {

    public int minExtraChar(String s, String[] dictionary) {
        int length = s.length();
        List<String> words = Arrays.asList(dictionary);

        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            temp.append(c);
        }


        return 0;
    }

}
