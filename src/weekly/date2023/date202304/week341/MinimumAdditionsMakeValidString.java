package weekly.date2023.date202304.week341;

import java.util.ArrayList;
import java.util.List;

/**
 * 6375. 构造有效字符串的最少插入数
 *
 * @author Real
 * @since 2023/4/16 11:00
 */
public class MinimumAdditionsMakeValidString {

    public static void main(String[] args) {
        MinimumAdditionsMakeValidString test = new MinimumAdditionsMakeValidString();
        String str = "aaa";
        System.out.println(test.addMinimum(str));
    }

    public int addMinimum(String word) {
        List<List<Character>> needAdditionText = new ArrayList<>();

        char[] chars = word.toCharArray();
        List<Character> temp = new ArrayList<>();
        for (char alphabet : chars) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) < alphabet) {
                temp.add(alphabet);
                continue;
            }

            List<Character> characters = new ArrayList<>(temp);
            needAdditionText.add(characters);
            temp = new ArrayList<>();
            temp.add(alphabet);
        }

        if (!temp.isEmpty()) {
            needAdditionText.add(temp);
        }

        int addition = 0;
        for (List<Character> characters : needAdditionText) {
            addition += 3 - characters.size();
        }

        return addition;
    }

}
