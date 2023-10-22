package weekly.date202310.week368;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wei.song
 * @since 2023/10/22 10:42
 */
public class MinGroupsForValidAssignment {

    public int minGroupsForValidAssignment(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> numberToCountMap = new HashMap<>();
        for (int num : nums) {
            numberToCountMap.put(num, numberToCountMap.getOrDefault(num, 0) + 1);
        }

        // TODO 判断 count 之间的相差
        Collection<Integer> values = numberToCountMap.values();
        int minCount = values.stream().min(Integer::compareTo).orElse(0);

        int groupCount = 0;
        for (int i = 1; i < minCount; i++) {
            for (int count : values) {
                if (count > i) {
                    // 分不断的情况下，是否会导致 minCount 刷新
                    if (count % i == i + 1 || count % i == i) {
                        groupCount += count / i + 1;
                    }
                }
            }
        }

        return groupCount;
    }

}
