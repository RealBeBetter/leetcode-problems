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
    }

    /**
     * 删除一个元素之后，最长连续为 1 的子数组长度
     *
     * @param nums 数组
     * @return int
     */
    public int longestSubarray(int[] nums) {
        int max = 0;
        int left = 0;

        int zeroIndex = -1;
        boolean hasZero = false;
        int tempLength = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 1) {
                tempLength++;
                continue;
            }

            hasZero = true;
            if (zeroIndex == -1) {
                zeroIndex = right;
            } else {
                max = Math.max(max, tempLength);
                tempLength = 0;
                // 这里是发现第二个 0 元素
                left = zeroIndex + 1;
                right = left;
                zeroIndex = -1;
            }

            max = Math.max(max, tempLength);
        }

        max = Math.max(max, tempLength);
        return hasZero ? max : nums.length - 1;
    }

}
