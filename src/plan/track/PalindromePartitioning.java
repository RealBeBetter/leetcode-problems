package plan.track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/">...</a>
 *
 * @author wei.song
 * @since 2023/10/17 12:11
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<String>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), s, 0);

        return result;
    }

    private void backtrack(List<List<String>> result, List<String> path, String s, int startIndex) {
        if (s.length() == startIndex) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
                backtrack(result, path, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
