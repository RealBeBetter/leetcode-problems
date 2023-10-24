package weekly.date202310.week368;

import java.util.HashMap;
import java.util.Map;

/**
 * 2910. 合法分组的最少组数
 * <a href="https://leetcode.cn/problems/minimum-number-of-groups-to-create-a-valid-assignment/">...</a>
 *
 * @author wei.song
 * @since 2023/10/22 10:42
 */
public class MinGroupsForValidAssignment {

    public static void main(String[] args) {
        MinGroupsForValidAssignment test = new MinGroupsForValidAssignment();
        int[] nums = {3, 2, 3, 2, 3};
        System.out.println(test.minGroupsForValidAssignment(nums));
    }

    public int minGroupsForValidAssignment(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> numberToCountMap = new HashMap<>();
        for (int num : nums) {
            numberToCountMap.put(num, numberToCountMap.getOrDefault(num, 0) + 1);
        }

        int length = nums.length;
        for (int cnt : numberToCountMap.values()) {
            length = Math.min(length, cnt);
        }

        for (; ; length--) {
            int ans = 0;
            for (int cnt : numberToCountMap.values()) {
                if (cnt / length < cnt % length) {
                    ans = 0;
                    break;
                }
                ans += (cnt + length) / (length + 1);
            }
            if (ans > 0) {
                return ans;
            }
        }
    }

}
