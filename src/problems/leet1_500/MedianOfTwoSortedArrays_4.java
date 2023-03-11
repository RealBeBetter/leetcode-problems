package problems.leet1_500;

/**
 * @ author : Real
 * @ date : 2021/11/2 15:50
 * @ description : 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianOfTwoSortedArrays_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 构建一个新的数组，存储合并之后的数组
        int[] array = new int[nums1.length + nums2.length];
        int point = 0;
        double ans = 0.0;
        int point1 = 0, point2 = 0;
        if (nums1.length == 0 || nums2.length == 0) {
            if (nums1.length == 0) {
                if (nums2.length % 2 == 0 && nums2.length != 0) {
                    return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
                } else if (nums2.length % 2 == 1){
                    return nums2[nums2.length / 2];
                }
            } else {
                // nums2 为空
                if (nums1.length % 2 == 0 && nums1.length != 0) {
                    return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
                } else if (nums1.length % 2 == 1){
                    return nums1[nums1.length / 2];
                }
            }
        }
        while (point1 <= nums1.length - 1 && point2 <= nums2.length - 1) {
            if (nums1[point1] < nums2[point2]) {
                array[point++] = nums1[point1++];
            } else if (nums1[point1] > nums2[point2]) {
                array[point++] = nums2[point2++];
            } else {
                array[point++] = nums1[point1++];
                array[point++] = nums2[point2++];
            }
        }
        // 如果循环跳出，那么表示其中一个走出循环
        while (point1 <= nums1.length - 1) {
            array[point++] = nums1[point1++];
        }
        while (point2 <= nums2.length - 1) {
            array[point++] = nums2[point2++];
        }

        if (array.length % 2 == 0) {
            // 偶数个，中位数应该怎么求
            ans = (array[array.length / 2] + array[array.length / 2 - 1]) / 2.0;
        } else {
            // 奇数个，中位数应该怎么求
            ans = array[array.length / 2];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-1, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
