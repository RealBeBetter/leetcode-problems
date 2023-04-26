package leetcode75.array;

/**
 * 334. 递增的三元子序列
 *
 * @author wei.song
 * @since 2023/4/25 16:40
 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        IncreasingTripletSubsequence test = new IncreasingTripletSubsequence();
        System.out.println(test.increasingTriplet(new int[]{20, 100, 10, 12, 5, 15}));
        System.out.println(test.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(test.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        // 左边最小值，右边最大值，构建前缀数组
        int length = nums.length;
        // left[i] 表示 [0, i-1] 中的最小值， right[i] 表示 [i+1, length-1] 中的最大值
        int[] left = new int[length], right = new int[length];
        left[0] = Integer.MAX_VALUE;
        right[length - 1] = Integer.MIN_VALUE;
        for (int i = 1, j = length - 2; i < length && j >= 0; i++, j--) {
            left[i] = Math.min(left[i - 1], nums[i - 1]);
            right[j] = Math.max(right[j + 1], nums[j + 1]);
        }

        // 比对除去首位的中间数据
        for (int i = 1; i < length - 1; i++) {
            if (left[i] < nums[i] && nums[i] < right[i]) {
                return true;
            }
        }
        return false;
    }
}
