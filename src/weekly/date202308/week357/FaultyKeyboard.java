package weekly.date202308.week357;

/**
 * 6925. 故障键盘
 * <a href="https://leetcode.cn/contest/weekly-contest-357/problems/faulty-keyboard/">...</a>
 *
 * @author wei.song
 * @since 2023/8/6 10:30
 */
public class FaultyKeyboard {

    public String finalString(String s) {
        // 优化：偶数个 i 连续出现需要消除
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        char[] charArray = s.toCharArray();
        int continuousCount = 0;

        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if (currentChar != 'i') {
                // 查看是否为 0
                if (continuousCount % 2 != 0) {
                    res.reverse();
                }
                res.append(currentChar);
                continuousCount = 0;
                continue;
            }

            // 如果是最后一个 i，需要反转
            continuousCount++;
            if (continuousCount % 2 == 0) {
                continuousCount = 0;
            }
            if (i == charArray.length - 1 && continuousCount % 2 != 0) {
                res.reverse();
            }
        }

        return res.toString();
    }

}
