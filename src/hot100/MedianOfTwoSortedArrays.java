package hot100;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * @author Real
 * Date: 2022/11/30 22:26
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2};
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 寻找两个正序数组的中位数
     * <p>
     * 凑到中间的中位数即可，构建新的数组，凑成新的数组即可。
     * 注意：奇数数组取中间值，偶数数组取中间两数平均值（所以偶数数组需要多取一位数）
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int numsLength = length % 2 == 0 ? length / 2 + 1 : (length + 1) / 2;
        int[] nums = new int[numsLength];
        int point = 0;
        for (int i = 0, j = 0; i < length1 || j < length2; ) {
            if (point == numsLength) {
                break;
            }
            // 考虑数组结束的情况
            if (i == length1 && j < length2) {
                nums[point++] = nums2[j++];
            } else if (i < length1 && j == length2) {
                nums[point++] = nums1[i++];
            } else if (i < length1 && j < length2) {
                nums[point++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else {
                break;
            }
        }
        // 偶数情况下，最后两个值平均
        return length % 2 == 0 ? (nums[numsLength - 1] + nums[numsLength - 2]) / 2.0 : nums[numsLength - 1];
    }

}
