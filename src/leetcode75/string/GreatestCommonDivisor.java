package leetcode75.string;

/**
 * 1071. 字符串的最大公因子
 *
 * @author Real
 * @since 2023/4/21 23:10
 */
public class GreatestCommonDivisor {

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        // 从长度大的开始枚举
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (len1 % i == 0 && len2 % i == 0) {
                String sub = str1.substring(0, i);
                if (check(str1, sub) && check(str2, sub)) {
                    return sub;
                }
            }
        }

        return "";
    }

    public boolean check(String str, String sub) {
        int num = str.length() / sub.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= num; ++i) {
            ans.append(sub);
        }

        return ans.toString().equals(str);
    }
}
