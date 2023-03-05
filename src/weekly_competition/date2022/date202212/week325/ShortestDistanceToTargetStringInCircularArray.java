package weekly_competition.date2022.date202212.week325;

import java.util.ArrayList;
import java.util.List;

/**
 * 6269. 到目标字符串的最短距离
 * 给你一个下标从 0 开始的 环形 字符串数组 words 和一个字符串 target 。环形数组 意味着数组首尾相连。
 * 形式上， words[i] 的下一个元素是 words[(i + 1) % n] ，而 words[i] 的前一个元素是 words[(i - 1 + n) % n] ，其中 n 是 words 的长度。
 * 从 startIndex 开始，你一次可以用 1 步移动到下一个或者前一个单词。
 * 返回到达目标字符串 target 所需的最短距离。如果 words 中不存在字符串 target ，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
 * 输出：1
 * 解释：从下标 1 开始，可以经由以下步骤到达 "hello" ：
 * - 向右移动 3 个单位，到达下标 4 。
 * - 向左移动 2 个单位，到达下标 4 。
 * - 向右移动 4 个单位，到达下标 0 。
 * - 向左移动 1 个单位，到达下标 0 。
 * 到达 "hello" 的最短距离是 1 。
 * 示例 2：
 * 输入：words = ["a","b","leetcode"], target = "leetcode", startIndex = 0
 * 输出：1
 * 解释：从下标 0 开始，可以经由以下步骤到达 "leetcode" ：
 * - 向右移动 2 个单位，到达下标 3 。
 * - 向左移动 1 个单位，到达下标 3 。
 * 到达 "leetcode" 的最短距离是 1 。
 * 示例 3：
 * 输入：words = ["i","eat","leetcode"], target = "ate", startIndex = 0
 * 输出：-1
 * 解释：因为 words 中不存在字符串 "ate" ，所以返回 -1 。
 * <p>
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 和 target 仅由小写英文字母组成
 * 0 <= startIndex < words.length
 *
 * @author Real
 * @since 2022/12/25 10:54
 */
public class ShortestDistanceToTargetStringInCircularArray {

    public static void main(String[] args) {
        ShortestDistanceToTargetStringInCircularArray test = new ShortestDistanceToTargetStringInCircularArray();
        String[] words = {"ibkgecmeyx", "jsdkekkjsb", "gdjgdtjtrs", "jsdkekkjsb", "jsdkekkjsb", "jsdkekkjsb", "gdjgdtjtrs", "msjlfpawbx", "pbgjhutcwb", "gdjgdtjtrs"};
        String target = "pbgjhutcwb";
        int startIndex = 0;
        System.out.println(test.closetTarget(words, target, startIndex));
    }

    /**
     * 找出最近的目标
     *
     * @param words      单词
     * @param target     目标
     * @param startIndex 开始下标值
     * @return int步长
     */
    public int closetTarget(String[] words, String target, int startIndex) {
        if (words == null || words.length == 0) {
            return -1;
        }
        int length = words.length;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (words[i].equals(target)) {
                index.add(i);
            }
        }
        if (index.size() == 0) {
            return -1;
        }
        int min = length;
        for (Integer indexValue : index) {
            int step = Math.abs(indexValue - startIndex);
            int reverseStep = length - step;
            min = Math.min(min, step);
            min = Math.min(min, reverseStep);
        }
        return min;
    }

}
