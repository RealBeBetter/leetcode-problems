package hot100;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 * <p>
 * 提示：
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * @author Real
 * @since 2023/2/23 23:27
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();

        System.out.println(test.longestValidParentheses("()(()"));
    }

    /**
     * 最长有效括号：题目转换
     * 使用栈进行模拟：
     * 用栈模拟一遍，将所有无法匹配的括号的位置全部置 1
     * 例如: "()(()"的 mark 为 [0, 0, 1, 0, 0]
     * 再例如: ")()((())"的 mark 为 [1, 0, 0, 1, 0, 0, 0, 0]
     * 经过这样的处理后, 此题就变成了寻找最长的连续的 0 的长度
     *
     * @param str 输入字符串
     * @return int 最大长度
     */
    public int longestValidParentheses(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        Stack<Integer> characterStack = new Stack<>();
        int[] marks = new int[str.length()];
        char[] parentheses = str.toCharArray();
        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] == '(') {
                // 注意存的是下标
                characterStack.push(i);
            } else {
                // 此时 stack 为空，表示 ) 不合法
                if (characterStack.isEmpty()) {
                    marks[i] = 1;
                } else {
                    characterStack.pop();
                }
            }
        }

        // 注意此时 Stack 中是否还有 ( 括号。
        while (!characterStack.isEmpty()) {
            marks[characterStack.pop()] = 1;
        }

        // 找出最长连续的 0 的长度
        int ans = 0;
        int tempSum = 0;
        for (int mark : marks) {
            if (mark == 0) {
                tempSum++;
            } else {
                ans = Math.max(ans, tempSum);
                tempSum = 0;
            }
        }

        return Math.max(ans, tempSum);
    }

}
