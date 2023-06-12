package problems.leet1001_1500;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 1306. 跳跃游戏 III
 * https://leetcode.cn/problems/jump-game-iii
 *
 * @author wei.song
 * @since 2023/6/13 0:10
 */
public class JumpGame {

    /**
     * 判断是否可以到达
     *
     * @param arr   arr数组
     * @param start 开始
     * @return boolean
     */
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> indexSet = new HashSet<>();
        LinkedList<Integer> indexQueue = new LinkedList<>();
        indexQueue.add(start);
        while (!indexQueue.isEmpty()) {
            Integer index = indexQueue.pop();
            indexSet.add(index);

            if (arr[index] == 0) {
                return true;
            }
            int left = index - arr[index];
            if (0 <= left && left < arr.length && !indexSet.contains(left)) {
                indexQueue.push(left);
            }
            int right = index + arr[index];
            if (0 <= right && right < arr.length && !indexSet.contains(right)) {
                indexQueue.push(right);
            }
        }

        return false;
    }

}
