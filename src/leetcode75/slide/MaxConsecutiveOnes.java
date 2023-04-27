package leetcode75.slide;

/**
 * 1004. 最大连续1的个数 III
 *
 * @author wei.song
 * @since 2023/4/27 18:04
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        MaxConsecutiveOnes test = new MaxConsecutiveOnes();
        // 6
        System.out.println(test.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        // 10
        System.out.println(test.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    /**
     * 连续的 1 的最长数量
     *
     * @param nums 数组
     * @param k    k
     * @return int
     */
    public int longestOnes(int[] nums, int k) {
        int start = 0, maxOnes = 0;

        int original = k;
        for (int end = 0; end < nums.length; ) {
            if (nums[end] == 0) {
                if (k == 0) {
                    start++;
                    k = original;
                    end = start;
                } else {
                    k--;
                    end++;
                }
            } else {
                end++;
            }

            maxOnes = Math.max(maxOnes, end - start);
        }

        return maxOnes;
    }
}
