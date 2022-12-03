package hot100;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * 提示：
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 * @author Real
 * Date: 2022/12/3 18:22
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(test.threeSum(nums));
    }

    /**
     * 三数之和
     * 排序 + 双指针即可，如果遇到满足条件的 ans，将左右指针同时向内移动
     *
     * @param nums 数组
     * @return 返回满足条件的集合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int length = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new LinkedHashSet<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                continue;
            }
            for (int j = i + 1, k = length - 1; j < length && k > j; ) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> temps = new LinkedList<>();
                    temps.add(nums[i]);
                    temps.add(nums[j]);
                    temps.add(nums[k]);
                    ans.add(temps);
                    k--;
                    j++;
                }
            }
        }
        return new ArrayList<>(ans);
    }

}
