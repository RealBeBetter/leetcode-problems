package problems.leet1501_2000;

/**
 * @ author : Real
 * @ date : 2021/10/30 19:21
 * @ description : 1567. 乘积为正数的最长子数组长度
 * 给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * 请你返回乘积为正数的最长子数组长度。
 * 示例 1：
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * 示例 2：
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumLengthOfSubarrayWithPositiveProduct_1567 {
    /**
     * 求解方式与最长无重复字串有相似之处，只是将长度改为正数，还要考虑是否存在两个负数的情况
     * 求解思路，将数组以0为分隔，将数组分隔成多个子数组，再分别遍历子数组
     * @param nums
     * @return int
     */
    public static int getMaxLen(int[] nums) {
        int maxLength = 0;          // 最长符合正数长度
        int arrayLength = 0;         // 临时数组的长度
        int negativeCount = 0;      // 负数个数
        int[] array = new int[nums.length]; // 临时创建的数组
        int[] negativeIndex = new int[nums.length]; // 创建保存负数的索引的数组
        for (int i = 0; i < nums.length; i++) {
            // 应该动态创建数组，逢0截断，采用迭代的方式，将数组划分
            if (nums[i] != 0) {
                // 不为0就加入数组
                array[arrayLength++] = nums[i];
                if (nums[i] < 0) {
                    negativeIndex[negativeCount++] = arrayLength - 1;
                }
            } else {
                // 为 0 则判断数组的长度，判断是否满足乘积为1的条件，判断完毕需要删除
                if (arrayLength != 0) {
                    // 不为 0 表示数组中有数字，长度为tempLength
                    if (negativeCount % 2 == 0) {
                        maxLength = Math.max(arrayLength, maxLength);
                    } else {
                        // 奇数个负数，应该截断，判断哪一截长度更大
                        // 为奇数个，记录了索引值的位置，那么就需要分情况讨论
                        int tempLength = 0;
                        if (negativeCount == 1) {
                            tempLength = Math.max(negativeIndex[0], arrayLength - 1 - negativeIndex[0]);
                        } else {
                            // 划分数组，要么去掉最后一个，要么去掉第一个
                            // 去掉最后一个的两种情况
                            tempLength = Math.max(arrayLength - 1 - negativeIndex[negativeCount - 1], negativeIndex[negativeCount - 1]);
                            // 两者中的较大值和首部前半部分
                            tempLength = Math.max(tempLength, negativeIndex[0]);
                            tempLength = Math.max(tempLength, arrayLength - 1 - negativeIndex[0]);
                        }
                        // 判断是否要更新最大值
                        maxLength = Math.max(tempLength, maxLength);
                    }
                }
                arrayLength = 0;
                negativeCount = 0;
            }
        }

        // 如果全部非0，则拿到最后判断一次
        if (arrayLength != 0) {
            // 不为 0 表示数组中有数字，长度为tempLength
            if (negativeCount % 2 == 0) {
                maxLength = Math.max(arrayLength, maxLength);
            } else {
                // 奇数个负数，应该截断，判断哪一截长度更大
                // 为奇数个，记录了索引值的位置，那么就需要分情况讨论
                int tempLength = 0;
                if (negativeCount == 1) {
                    tempLength = Math.max(negativeIndex[0], arrayLength - 1 - negativeIndex[0]);
                } else {
                    // 划分数组，要么去掉最后一个，要么去掉第一个
                    // 去掉最后一个的两种情况
                    tempLength = Math.max(arrayLength - 1 - negativeIndex[negativeCount - 1], negativeIndex[negativeCount - 1]);
                    // 两者中的较大值和去掉第一个的前半部分
                    tempLength = Math.max(tempLength, negativeIndex[0]);
                    // 两者中的较大值和去掉第一个的后半部分
                    tempLength = Math.max(tempLength, arrayLength - 1 - negativeIndex[0]);
                }
                // 判断是否要更新最大值
                maxLength = Math.max(tempLength, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, -2, -3, 4};  // 4
        int[] nums2 = {0, 1, -2, -3, -4};  // 3
        int[] nums3 = {1000000000,1000000000};  // 2
        System.out.println(getMaxLen(nums1));
    }
}
