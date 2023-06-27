package leetcode75.trace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * @author wei.song
 * @since 2023/6/27 17:51
 */
public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations test = new LetterCombinations();
        System.out.println(test.letterCombinations("23"));
    }

    /**
     * 初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
     */
    private final String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        ArrayList<String> res = new ArrayList<>();
        return backtrack(digits, 0, res);
    }

    private List<String> backtrack(String digits, int index, List<String> res) {
        if (index == digits.length()) {
            return res;
        }

        int number = Integer.parseInt(digits.charAt(index) + "");

        String next = numString[number];

        List<String> nextStrings = new ArrayList<>();

        char[] chars = next.toCharArray();
        for (char c : chars) {
            if (res.isEmpty()) {
                nextStrings.add(c + "");
            } else {
                for (String str : res) {
                    String nextStr = str + c;
                    nextStrings.add(nextStr);
                }
            }
        }

        return backtrack(digits, index + 1, nextStrings);
    }

}
