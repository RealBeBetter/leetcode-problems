package problems.leet2001_2500;

/**
 * 2027. 转换字符串的最少操作次数
 *
 * @author wei.song
 * @since 2023/3/30 17:36
 */
public class MinimumMovesToConvertString {

    public int minimumMoves(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'X') {
                ans++;
                i += 2;
            }
        }

        return ans;
    }

}
