package leetcode75.slide;

/**
 * @author wei.song
 * @since 2023/4/27 18:34
 */
public class LongestSubarrayDeletingOne {

    public static void main(String[] args) {
        LongestSubarrayDeletingOne test = new LongestSubarrayDeletingOne();
        // 5
        System.out.println(test.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(test.longestSubarray(new int[]{1, 1, 0, 1}));
    }

    /**
     * 删除一个元素之后，最长连续为 1 的子数组长度
     * 要素：定义好各种情况，想好比对的时机
     *
     * @param nums 数组
     * @return int
     */
    public int longestSubarray(int[] nums) {
        int max = 0, left = 0, right = 0;
        boolean hasZero = false;
        while (right < nums.length) {
            // 计算两者之间的差距，因为要去掉一个数字
            if (nums[right] == 1) {
                // 符合条件的时候才进行对比
                max = Math.max(max, right - left);
                right++;
            } else {
                if (!hasZero) {
                    max = Math.max(max, right - left);
                    right++;
                    hasZero = true;
                } else {
                    left++;
                    right = left;
                    hasZero = false;
                }
            }
        }

        return max;
    }

}
