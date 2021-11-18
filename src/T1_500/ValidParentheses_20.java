package T1_500;

import java.util.Stack;

/**
 * @ author : Real
 * @ date : 2021/10/28 1:52
 * @ description :
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        // 利用栈，将左边括号压栈，新加入的值跟栈内元素匹配，如果匹配就弹栈
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (stack.size() == 0) {
                stack.push(str[i]);
            } else if ( (stack.peek() == '(' && str[i] == ')') || (stack.peek() == '{' && str[i] == '}') || (stack.peek() == '[' && str[i] == ']') ) {
                stack.pop();
            } else {
                stack.push(str[i]);
            }
        }
        return stack.size() == 0;
    }
}
