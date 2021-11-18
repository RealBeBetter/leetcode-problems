package T1_500;

/**
 * @ author : Real
 * @ date : 2021/11/5 22:25
 * @ description : 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 * <p>
 * 提示：
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        // 盛水最多的容器，返回的是最大的容量
        // 容量 = Math.min(height[i],height[j]) * Math.abs(i-j)
        // 说明：i 与 j 不相同，根据木桶效应，容积由短板以及两板之间的宽度决定

        int ans = 0;
        // 根据这个逻辑，直接暴力，超时
        /*for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = Math.min(height[i],height[j]) * (j-i);
                ans = Math.max(temp, ans);
            }
        }*/

        // 第一次剪枝，两数之积，宽度优先，桶的右边从数组的右边开始遍历，超时
        /*for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                int temp = Math.min(height[i], height[j]) * (j-i);
                ans = Math.max(temp, ans);
            }
        }*/

        // 第二次剪枝，使用双指针的方式，宽度上从两边开始，左右的移动从低的一侧开始，O(n)
        for (int i = 0, j = height.length - 1; j > i; ) {
            int temp = Math.min(height[i], height[j]) * (j - i);
            ans = Math.max(temp, ans);
            if (height[i] < height[j]) {
                i++;
            } else if (height[i] > height[j]) {
                j--;
            } else {
                i++;
                j--;
            }
        }


        return ans;
    }
}
