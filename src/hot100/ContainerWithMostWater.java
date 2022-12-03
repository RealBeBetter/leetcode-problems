package hot100;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 * @author Real
 * Date: 2022/12/3 18:12
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater test = new ContainerWithMostWater();
        System.out.println(test.maxArea(height));
    }

    /**
     * 盛水最多的容器，输出能容纳的最大容量
     *
     * @param height 高度数组
     * @return 容量
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        int ans = 0;
        while (leftIndex < rightIndex) {
            int left = height[leftIndex];
            int right = height[rightIndex];
            int width = rightIndex - leftIndex;
            int minHeight = Math.min(left, right);
            if (left < right) {
                leftIndex++;
            } else {
                rightIndex--;
            }
            ans = Math.max(minHeight * width, ans);
        }
        return ans;
    }

}
