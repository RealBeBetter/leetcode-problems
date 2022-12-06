package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 *
 * @author wei.song
 * @since 2022/12/6 19:48
 */
public class GenerateParentheses {

    List<String> res = new ArrayList<>();

    /**
     * 括号生成，输入 n ，字符串一共包含 2n 个字符，(、) 各 n 个
     * 使用暴力生成所有的括号，逐一判断是否含有目标括号切是否合法
     * <p>
     * dfs 遍历生成目标括号
     *
     * @param n 括号数
     * @return List
     */
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) {
            // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) {
            // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) {
            // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }

}
