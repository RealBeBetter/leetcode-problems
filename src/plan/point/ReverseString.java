package plan.point;

/**
 * @author Real
 * @since 2023/3/4 23:37
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int length = s.length;
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

}
