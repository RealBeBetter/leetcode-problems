package weekly.date202303.week338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6357. 使数组元素全部相等的最少操作次数
 *
 * @author Real
 * @since 2023/3/26 10:49
 */
public class MinimumOperationsMakeElementsEqual {

    public static void main(String[] args) {
        int[] array = {3, 1, 6, 8};
        int[] queries = {1, 5};
        List<Long> longs = minOperations(array, queries);
        System.out.println(longs);
    }

    /**
     * 最小操作次数，每次将nums中的数字都变成queries[i]的次数
     *
     * @param nums    数组
     * @param queries 查询
     * @return {@link List}<{@link Long}>
     */
    public static List<Long> minOperations(int[] nums, int[] queries) {
        if (nums == null || queries == null) {
            return null;
        }

        Arrays.sort(nums);
        int length = nums.length;
        long[] prefixSum = new long[length + 1];
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int query : queries) {
            int index = getLowerBound(nums, query);
            long pre = (long) query * index - prefixSum[index];
            long aft = prefixSum[length] - prefixSum[index] - (long) query * (length - index);
            ans.add(pre + aft);
        }

        return ans;
    }

    private static int getLowerBound(int[] nums, int target) {
        // 开区间 (left, right)
        int left = -1, right = nums.length;
        // 区间不为空
        while (left + 1 < right) {
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 范围缩小到 (mid, right)
                left = mid;
            } else {
                // 范围缩小到 (left, mid)
                right = mid;
            }
        }
        return right;
    }

}
