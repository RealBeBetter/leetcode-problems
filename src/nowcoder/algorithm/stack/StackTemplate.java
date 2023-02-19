package nowcoder.algorithm.stack;

import java.util.Scanner;

/**
 * AB1 【模板】栈
 * 中等  通过率：45.38%  时间限制：1秒  空间限制：256M
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 请你实现一个栈。
 * 操作：
 * push x：将 加
 * <p>
 * x 入栈，保证
 * <p>
 * x 为 int 型整数。
 * pop：输出栈顶，并让栈顶出栈
 * top：输出栈顶，栈顶不出栈
 * 输入描述：
 * 第一行为一个正整数。
 * n ，代表操作次数。
 * n ，每行为一个字符串，代表一个操作。保证操作是题目描述中三种中的一种。
 * <p>
 * 输出描述：
 * 如果操作为push，则不输出任何东西。
 * 如果为另外两种，若栈为空，则输出 "error“
 * 否则按对应操作输出。
 *
 * @author wei.song
 * @since 2023/2/19 13:23
 */
public class StackTemplate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }




}
