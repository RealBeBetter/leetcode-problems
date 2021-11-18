import java.util.LinkedHashSet;

/**
 * @ author : Real
 * @ date : 2021/11/12 15:18
 * @ description :
 *  输入样例："fbccdeeffeeeacb"
 *     输出结果："fbcdea"（去重并保持原来顺序）
 */
public class Test {

    public static String changeString(String s) {
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!linkedHashSet.contains(chars[i])) {
                linkedHashSet.add(chars[i]);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character character : linkedHashSet) {
            ans.append(character);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String ans = changeString("fbccdeeffeeeacb");
        System.out.println(ans);
    }
}
