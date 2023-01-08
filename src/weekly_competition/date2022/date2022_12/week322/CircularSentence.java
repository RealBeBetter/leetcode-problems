package weekly_competition.date2022.date2022_12.week322;

/**
 * 6253. 回环句 显示英文描述
 * 句子 是由单个空格分隔的一组单词，且不含前导或尾随空格。
 * 例如，"Hello World"、"HELLO"、"hello world hello world" 都是符合要求的句子。
 * 单词 仅 由大写和小写英文字母组成。且大写和小写字母会视作不同字符。
 * <p>
 * 如果句子满足下述全部条件，则认为它是一个 回环句 ：
 * 单词的最后一个字符和下一个单词的第一个字符相等。
 * 最后一个单词的最后一个字符和第一个单词的第一个字符相等。
 * 例如，"leetcode exercises sound delightful"、"eetcode"、"leetcode eats soul" 都是回环句。
 * 然而，"Leetcode is cool"、"happy Leetcode"、"Leetcode" 和 "I like Leetcode" 都 不 是回环句。
 * 给你一个字符串 sentence ，请你判断它是不是一个回环句。如果是，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：sentence = "leetcode exercises sound delightful"
 * 输出：true
 * 解释：句子中的单词是 ["leetcode", "exercises", "sound", "delightful"] 。
 * - leetcode 的最后一个字符和 exercises 的第一个字符相等。
 * - exercises 的最后一个字符和 sound 的第一个字符相等。
 * - sound 的最后一个字符和 delightful 的第一个字符相等。
 * - delightful 的最后一个字符和 leetcode 的第一个字符相等。
 * 这个句子是回环句。
 * 示例 2：
 * 输入：sentence = "eetcode"
 * 输出：true
 * 解释：句子中的单词是 ["eetcode"] 。
 * - eetcode 的最后一个字符和 eetcode 的第一个字符相等。
 * 这个句子是回环句。
 * 示例 3：
 * 输入：sentence = "Leetcode is cool"
 * 输出：false
 * 解释：句子中的单词是 ["Leetcode", "is", "cool"] 。
 * - Leetcode 的最后一个字符和 is 的第一个字符 不 相等。
 * 这个句子 不 是回环句。
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 500
 * sentence 仅由大小写英文字母和空格组成
 * sentence 中的单词由单个空格进行分隔
 * 不含任何前导或尾随空格
 *
 * @author Real
 * Date: 2022/12/4 10:58
 */
public class CircularSentence {

    public static void main(String[] args) {
        String s = "Leetcode is cool";
        String s1 = "eetcode";
        String s2 = "leetcode exercises sound delightful";
        CircularSentence test = new CircularSentence();
        System.out.println(test.isCircularSentence(s));
        System.out.println(test.isCircularSentence(s1));
        System.out.println(test.isCircularSentence(s2));
    }


    public boolean isCircularSentence(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return false;
        }
        String[] words = sentence.split(" +");
        char first = words[0].charAt(0);
        char last = words[words.length - 1].charAt(words[words.length - 1].length() - 1);
        if (first != last) {
            return false;
        }
        char tempEnd = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            char tempBegin = words[i].charAt(0);
            if (tempBegin != tempEnd) {
                return false;
            }
            tempEnd = words[i].charAt(words[i].length() - 1);
        }
        return true;
    }

}
