package leetcode75.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * https://leetcode.cn/problems/non-overlapping-intervals
 *
 * @author wei.song
 * @since 2023/6/30 14:29
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
        NonOverlappingIntervals test = new NonOverlappingIntervals();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(test.eraseOverlapIntervals(intervals));
    }


    /**
     * 消除重叠时间间隔，例如[1,4],[1,2],[2,3],[3,4]返回[1,4]的数量1
     *
     * @param intervals 时间间隔
     * @return int 去除的最小数量
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int ans = 1;

        int length = intervals.length;
        int right = intervals[0][1];
        for (int i = 1; i < length; ++i) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return length - ans;
    }

}
