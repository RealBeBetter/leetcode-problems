package weekly.date2023.date202303.week338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6357. 使数组元素全部相等的最少操作次数
 *
 * @author wei.song
 * @since 2023/3/30 16:47
 */
public class MinOperations {


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
        List<Long> ans = new ArrayList<>();
        long[] prefixSum = getPrefixSum(nums);
        for (int query : queries) {
            int insertPoint = Arrays.binarySearch(nums, query);
            int index = insertPoint >= 0 ? insertPoint : Math.abs(insertPoint) - 1;
            long pre = (long) query * index - prefixSum[index];
            long aft = prefixSum[length] - prefixSum[index] - (long) query * (length - index);
            ans.add(pre + aft);
        }

        return ans;
    }

    private static long[] getPrefixSum(int[] nums) {
        int length = nums.length;
        long[] prefix = new long[length + 1];

        for (int i = 0; i < length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix;
    }
}
