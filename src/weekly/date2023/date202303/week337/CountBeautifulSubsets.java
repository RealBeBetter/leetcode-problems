package weekly.date2023.date202303.week337;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 6352. 美丽子集的数目
 *
 * @author Real
 * @since 2023/3/19 11:30
 */
public class CountBeautifulSubsets {

    /**
     * 美丽子集个数，k>=1，默认单个数字均符合
     *
     * @param nums 原数组
     * @param k    k
     * @return int
     */
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return beautifulSubsets(0, new HashMap<>(32), nums, k) - 1;
    }

    private int beautifulSubsets(int index, HashMap<Integer, Integer> map, int[] nums, int k) {
        if (index == nums.length) {
            return 1;
        }

        int count = beautifulSubsets(index + 1, map, nums, k);
        if (map.getOrDefault(nums[index] - k, 0) == 0) {
            map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
            count += beautifulSubsets(index + 1, map, nums, k);
            map.put(nums[index], map.get(nums[index]) - 1);
        }
        return count;
    }

}
