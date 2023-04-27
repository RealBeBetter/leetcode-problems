package leetcode75.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1207. 独一无二的出现次数
 *
 * @author Real
 * @since 2023/4/27 23:09
 */
public class UniqueNumberOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>((int) (arr.length / 0.75 + 1));

        for (int i : arr) {
            if (occurrences.containsKey(i)) {
                occurrences.put(i, occurrences.get(i) + 1);
            } else {
                occurrences.put(i, 1);
            }
        }

        List<Integer> values = new ArrayList<>(occurrences.values());
        int originalSize = values.size();
        long count = values.stream().distinct().count();
        return count == originalSize;
    }

}
