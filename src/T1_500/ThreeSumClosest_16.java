package T1_500;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ author : Real
 * @ date : 2021/11/15 16:18
 * @ description : 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * 提示：
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest_16 {
    public static int threeSumClosest(int[] nums, int target) {
        // 解法一：直接暴力，三个数进行三次遍历，比较耗时，N ^ 3
        /*// 计算值和目标值的差值应该小于这个数
        int subValue = Integer.MAX_VALUE;
        // 计算的答案值
        int ans = target;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] + nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int tempSum = temp + nums[k];
                    if (Math.abs(tempSum - target) < subValue) {
                        ans = tempSum;
                        subValue = Math.abs(tempSum - target);
                    }
                }
            }
        }
        return ans;*/

        // 解法二：排序之后固定一个数，再通过首尾双指针移动数据，N ^ 2
        Arrays.sort(nums);
        int subValue = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp > target) {
                    // 三数之和过大，应该移动右边的指针
                    k--;
                } else if (temp < target) {
                    j++;
                } else {
                    return target;
                }
                if (Math.abs(temp - target) < subValue) {
                    subValue = Math.abs(temp - target);
                    ans = temp;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int i = threeSumClosest(nums, target);
        System.out.println(i);
    }
}
