package hot100;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author Real
 * @since 2023/3/21 20:51
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("3.1415"));
        System.out.println(myAtoi("+54"));
        System.out.println(myAtoi("+0054"));
        System.out.println(myAtoi("-0054"));
        System.out.println(myAtoi("    123 -0054"));
        System.out.println(myAtoi("21474836460"));
        System.out.println(myAtoi("  0000000000012345678"));
    }

    /**
     * atoi 函数
     *
     * @param str 字符串
     * @return int
     */
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }


        int index = 0, n = str.length(), sign = 1, res = 0;
        // 处理前置空格
        while (index < n && str.charAt(index) == ' ') {
            ++index;
        }
        // 处理符号
        if (index < n && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }
        // 处理数字
        while (index < n && (str.charAt(index) >= '0' && str.charAt(index) <= '9')) {
            int digit = str.charAt(index) - '0';
            // 判断是否溢出
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            ++index;
        }
        return res * sign;
    }

}
