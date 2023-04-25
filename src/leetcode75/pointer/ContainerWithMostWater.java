package leetcode75.pointer;

/**
 * 11. 盛最多水的容器
 *
 * @author Real
 * @since 2023/4/25 22:42
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int mostWater = 0;

        int leftPointer = 0, rightPointer = height.length - 1;
        while (leftPointer < rightPointer) {
            int leftHeight = height[leftPointer];
            int rightHeight = height[rightPointer];
            int minHeight = Math.min(leftHeight, rightHeight);
            int water = (rightPointer - leftPointer) * minHeight;
            mostWater = Math.max(mostWater, water);

            if (leftHeight < rightHeight) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return mostWater;
    }

}
