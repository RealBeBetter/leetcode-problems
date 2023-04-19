package problems.leet1_500;


/**
 * 11. 盛最多水的容器
 *
 * @author Real
 * @since 2023/04/19 11:12
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        // 盛水最多的容器，返回的是最大的容量
        // 容量 = Math.min(height[i],height[j]) * Math.abs(i-j)
        // 说明：i 与 j 不相同，根据木桶效应，容积由短板以及两板之间的宽度决定
        int ans = 0;
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
