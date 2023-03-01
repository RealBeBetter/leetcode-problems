package problems.T1_500;

import java.util.PriorityQueue;

/**
 * @ author : Real
 * @ date : 2021/11/15 20:56
 * @ description : 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 提示：
 * 1 <= k <= nums.length <= 104
 * -104<= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthLargestElementInAnArray_215 {
    // 计算第 K 大的数
    // https://www.cnblogs.com/kyoner/p/10465633.html
    public static int findKthLargest(int[] nums, int k) {
        // 第一种方法，冒泡 K 次
        /*for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums[nums.length - k];*/

        // 第二种，分治法，利用快排实现，将原数组


        // 第三种，小顶堆法
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (heap.size() < k) {
                heap.add(nums[i]);
            } else {
                if (nums[i] > heap.peek()) {
                    heap.poll();
                    heap.add(nums[i]);
                }
            }
        }
        return heap.peek();


    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(array, k));
    }
}
