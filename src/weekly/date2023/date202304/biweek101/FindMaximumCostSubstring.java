package weekly.date2023.date202304.biweek101;

import java.util.HashMap;
import java.util.Map;

/**
 * 6328. 找到最大开销的子字符串
 *
 * @author Real
 * @since 2023/4/1 22:45
 */
public class FindMaximumCostSubstring {

    public int maximumCostSubstring(String str, String chars, int[] values) {
        int length = values.length;
        Map<Character, Integer> characterCostMap = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            characterCostMap.put(chars.charAt(i), values[i]);
        }

        int maxCost = 0;
        int tempCost = 0;
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            int currentCost = characterCostMap.containsKey(c) ? characterCostMap.get(c) : c - 'a' + 1;
            tempCost = Math.max(tempCost + currentCost, 0);
            maxCost = Math.max(maxCost, tempCost);
        }

        return maxCost;
    }

}
