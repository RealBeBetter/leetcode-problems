package weekly.date202308.week357;

import java.util.List;

/**
 * 6953. 判断是否能拆分数组
 * <a href="https://leetcode.cn/contest/weekly-contest-357/problems/check-if-it-is-possible-to-split-array/">...</a>
 *
 * @author wei.song
 * @since 2023/8/6 10:45
 */
public class SplitArray {

    public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size() <= 2) {
            return true;
        }

        int index = 0;
        int maxIndex = nums.size() - 1;
        while (index < maxIndex) {
            if (nums.get(index) + nums.get(index + 1) >= m) {
                return true;
            }
            index++;
        }

        return false;
    }

}
