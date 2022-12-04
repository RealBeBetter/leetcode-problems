package hot100;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author Real
 * Date: 2022/12/3 22:43
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String str = "(])";
        ValidParentheses test = new ValidParentheses();
        boolean validByStack = test.isValidByStack(str);
        System.out.println(validByStack);
    }

    /**
     * 判断括号是否合法
     *
     * @param s 括号
     * @return 是否合法
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int count = s.length() / 2;
        while (count-- != 0) {
            s = s.replace("()", "")
                    .replace("[]", "")
                    .replace("{}", "");
        }
        return s.length() == 0;
    }

    public boolean isValidByStack(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(s.charAt(i));
            } else {
                Character stackPeek = stack.size() != 0 ? stack.peek() : null;
                if (stackPeek == null) {
                    return false;
                }
                if (stackPeek == '(' && c == ')') {
                    stack.pop();
                } else if (stackPeek == '[' && c == ']') {
                    stack.pop();
                } else if (stackPeek == '{' && c == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

}
