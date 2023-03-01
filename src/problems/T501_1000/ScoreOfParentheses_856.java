package problems.T501_1000;

/**
 * @ author : Real
 * @ date : 2021/11/15 18:12
 * @ description : 856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * 示例 1：
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * 输入： "(())"
 * 输出： 2
 * 示例3：
 * 输入： "()()"
 * 输出： 2
 * 示例4：
 * 输入： "(()(()))"
 * 输出： 6
 * <p>
 * 提示：
 * S是平衡括号字符串，且只含有(和)。
 * 2 <= S.length <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ScoreOfParentheses_856 {

    public static int scoreOfParentheses(String s) {
        // 方法一：直接使用栈，入栈操作，使用数组来对应字符串的值
        /*
            下面给出了字符串 (()(())) 每次对应的栈的情况：
            [0, 0] (
            [0, 0, 0] ((
            [0, 1] (()
            [0, 1, 0] (()(
            [0, 1, 0, 0] (()((
            [0, 1, 1] (()(()
            [0, 3] (()(())
            [6] (()(()))
         */
        /*Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 左半边括号
                stack.push(0);
            } else {
                // 右半边括号的情况中，
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(Math.max(1, 2 * pop1) + pop2);
            }
        }
        return stack.peek();*/

        // 方法二：直接记录层数，利用层数计算
        int depth = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
            }
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                // ans += Math.pow(2, depth)
                ans += 1 << depth;      // 1 * 2 ^ depth
            }
        }
        return ans;
    }

}
