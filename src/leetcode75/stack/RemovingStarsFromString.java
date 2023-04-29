package leetcode75.stack;

import java.util.Stack;

/**
 * @author wei.song
 * @since 2023/4/29 22:01
 */
public class RemovingStarsFromString {

    public String removeStars(String str) {
        Stack<Character> stack = new Stack<>();

        int length = str.length();
        for (int i = 0; i < length; i++) {
            char character = str.charAt(i);
            if (character == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(character);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

}
