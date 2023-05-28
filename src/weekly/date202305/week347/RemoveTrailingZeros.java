package weekly.date202305.week347;

/**
 * 6457. 移除字符串中的尾随零
 *
 * @author Real
 * @since 2023/5/28 11:01
 */
public class RemoveTrailingZeros {

    public String removeTrailingZeros(String num) {
        char[] chars = num.toCharArray();
        int index = -1;

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '0') {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return num.substring(0, index + 1);
        }
        return num;
    }

}
