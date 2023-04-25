package leetcode75.string;

/**
 * 443. 压缩字符串
 *
 * @author Real
 * @since 2023/4/25 21:33
 */
public class StringCompression {

    /**
     * 压缩后的长度
     *
     * @param chars 字符数组
     * @return int
     */
    public int compress(char[] chars) {
        int length = chars.length;

        int point = 0;
        char temp = chars[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (chars[i] == temp) {
                count++;
                continue;
            }

            point = compressChar(chars, point, temp, count);

            // 替换
            temp = chars[i];
            count = 1;
        }

        point = compressChar(chars, point, temp, count);

        return point;
    }

    private int compressChar(char[] chars, int point, char temp, int count) {
        chars[point++] = temp;
        String countText = String.valueOf(count);
        int countLength = countText.length();
        if (count > 1) {
            for (int j = 0; j < countLength; j++) {
                chars[point++] = countText.charAt(j);
            }
        }
        return point;
    }

}
