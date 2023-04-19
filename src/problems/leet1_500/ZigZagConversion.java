package problems.leet1_500;

/**
 * 6. Z 字形变换
 *
 * @author Real
 * @date 2023/04/19 11:32
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        // Z 字形变换，numRows表示的是行数，计算中间会出现的个数应该是 numRows - 2
        // 所以1与2及以上的应该分开讨论
        StringBuilder ans = new StringBuilder();
        if (numRows == 1 || s.length() <= numRows) {
            // 如果长度小于行数，直接输出原状
            return s;
        }
        // 2 以及 以上
        for (int i = 0; i < numRows; i++) {
            // 第 i 行相邻的两个元素应该是 i ~ i + numRows + 1
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j += (numRows - 1) * 2) {
                    ans.append(s.charAt(j));
                }
            } else {
                // 判断行数然后进行计算，需要记录一个方向
                // 0 表示向下，1表示向上，初始值向下
                int flag = 0;
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
        return ans.toString();
    }

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        String t1 = "PINALSIGYAHRPI";
        System.out.println(convert(s1, 4).equals(t1));
        System.out.println("输出值 " + convert(s1, 4));
        System.out.println("目标值 " + t1);
    }
}
