package weekly.date2023.date202304.week340;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6360. 等值距离和
 *
 * @author Real
 * @since 2023/4/9 10:46
 */
public class SumOfDistances {

    /**
     * 距离
     *
     * @param nums 数组
     * @return {@link long[]}
     */
    public long[] distance(int[] nums) {
        // 设计一个 Map，value 存储 index 值集合
        Map<Integer, List<Integer>> sameValMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            sameValMap.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);
        }

        long[] arr = new long[nums.length];
        long[] preSum = new long[nums.length + 1];
        for (List<Integer> value : sameValMap.values()) {
            int size = value.size();
            for (int i = 0; i < size; i++) {
                // 计算前缀和
                preSum[i + 1] = preSum[i] + value.get(i);
            }

            for (int i = 0; i < size; i++) {
                Integer target = value.get(i);
                long left = (long) target * i - preSum[i];
                long right = preSum[size] - preSum[i] - (long) target * (size - i);
                arr[target] = left + right;
            }
        }

        return arr;
    }
}
