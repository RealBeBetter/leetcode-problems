package leetcode75.stack;

import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * @author wei.song
 * @since 2023/4/29 22:36
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString test = new DecodeString();
        System.out.println(test.decodeString("3[a]2[bc]"));
        System.out.println(test.decodeString("3[a2[c]]"));
        System.out.println(test.decodeString("2[abc]3[cd]ef"));
        System.out.println(test.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public String decodeString(String str) {
        Stack<Character> stack = new Stack<>();

        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char character = str.charAt(i);
            if (character != ']') {
                stack.push(character);
            } else {
                String current = buildDecodeText(stack);
                if (!stack.isEmpty()) {
                    for (char c : current.toCharArray()) {
                        stack.add(c);
                    }
                } else {
                    sb.append(current);
                }
            }
        }

        for (Character character : stack) {
            sb.append(character);
        }

        return sb.toString();
    }

    private String buildDecodeText(Stack<Character> stack) {
        StringBuilder temp = new StringBuilder();
        StringBuilder numberText = new StringBuilder();
        while (stack != null && !stack.isEmpty()) {
            if (stack.peek() >= 'a' && stack.peek() <= 'z') {
                if (numberText.length() > 0) {
                    break;
                }
                temp.append(stack.pop());
            } else if (stack.peek() >= '0' && stack.peek() <= '9') {
                numberText.append(stack.pop());
            } else if (stack.peek() == '[') {
                if (numberText.length() > 0) {
                    break;
                }
                stack.pop();
            }
        }

        int number = 1;
        StringBuilder reverse = numberText.reverse();
        if (reverse.length() != 0) {
            number = Integer.parseInt(reverse.toString());
        }

        String text = temp.reverse().toString();
        StringBuilder ans = new StringBuilder();
        while (number-- > 0) {
            ans.append(text);
        }

        return ans.toString();
    }

}
