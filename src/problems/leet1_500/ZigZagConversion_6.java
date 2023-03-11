package problems.leet1_500;

/**
 * @ author : Real
 * @ date : 2021/11/3 12:27
 * @ description : 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigZagConversion_6 {
    public static String convert(String s, int numRows) {
        // Z 字形变换，numRows表示的是行数，计算中间会出现的个数应该是 numRows - 2
        // 所以1与2及以上的应该分开讨论
        StringBuilder ans = new StringBuilder();
        if (numRows == 1 || s.length() <= numRows) {
            // 如果长度小于行数，直接输出原状
            return s;
        } else {
            // 2 以及 以上
            for (int i = 0; i < numRows; i++) {
                // 第 i 行相邻的两个元素应该是 i ~ i + numRows + 1
                if (i == 0 || i == numRows - 1) {
                    for (int j = i; j < s.length(); j += (numRows - 1) * 2) {
                        ans.append(s.charAt(j));
                    }
                } else {
                    // 判断行数然后进行计算，需要记录一个方向
                    int flag = 0;       // 0 表示向下，1表示向上，初始值向下
                    for (int j = i; j < s.length(); ) {
                        ans.append(s.charAt(j));
                        if (flag == 0) {
                            j += (numRows - 1 - i) * 2;
                            flag = 1;
                        } else {
                            // 向上方向
                            j += i * 2;
                            flag = 0;
                        }
                    }
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String t = "PAHNAPLSIIGYIR";

        String s1 = "PAYPALISHIRING";
        String t1 = "PINALSIGYAHRPI";
        System.out.println(convert(s1, 4).equals(t1));
        System.out.println("输出值 " + convert(s1, 4));
//        System.out.println(convert(s, 3).equals(t));
        System.out.println("目标值 " + t1);
    }
}
