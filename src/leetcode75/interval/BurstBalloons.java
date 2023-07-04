package leetcode75.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * @author wei.song
 * @since 2023/7/4 14:19
 */
public class BurstBalloons {

    /**
     * 查找最小箭头击穿数
     *
     * @param points 坐标点集合
     * @return int
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int length = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int ans = 1;
        // 右坐标
        int right = points[0][1];
        for (int i = 1; i < length; i++) {
            // 左侧开始坐标 > 上一个右侧，表示不重合，ans++
            if (points[i][0] > right) {
                ans++;
                right = points[i][1];
            }
        }

        return ans;
    }

}
