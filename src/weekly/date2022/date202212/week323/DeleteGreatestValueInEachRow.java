package weekly.date2022.date202212.week323;

import java.util.Arrays;

/**
 * 6257. 删除每行中的最大值
 * 给你一个 m x n 大小的矩阵 grid ，由若干正整数组成。
 * 执行下述操作，直到 grid 变为空矩阵：
 * 从每一行删除值最大的元素。如果存在多个这样的值，删除其中任何一个。
 * 将删除元素中的最大值与答案相加。
 * 注意 每执行一次操作，矩阵中列的数据就会减 1 。
 * 返回执行上述操作后的答案。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,2,4],[3,3,1]]
 * 输出：8
 * 解释：上图展示在每一步中需要移除的值。
 * - 在第一步操作中，从第一行删除 4 ，从第二行删除 3（注意，有两个单元格中的值为 3 ，我们可以删除任一）。在答案上加 4 。
 * - 在第二步操作中，从第一行删除 2 ，从第二行删除 3 。在答案上加 3 。
 * - 在第三步操作中，从第一行删除 1 ，从第二行删除 1 。在答案上加 1 。
 * 最终，答案 = 4 + 3 + 1 = 8 。
 * 示例 2：
 * 输入：grid = [[10]]
 * 输出：10
 * 解释：上图展示在每一步中需要移除的值。
 * - 在第一步操作中，从第一行删除 10 。在答案上加 10 。
 * 最终，答案 = 10 。
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 100
 *
 * @author Real
 * @since 2022/12/11 11:09
 */
public class DeleteGreatestValueInEachRow {

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        int i = deleteGreatestValue(grid);
        System.out.println(i);
    }

    /**
     * 删除每一行中的最大值，直到变成空矩阵
     *
     * @param grid 二维数组
     * @return 删除之后的二维数组
     */
    public static int deleteGreatestValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int length = grid.length;
        int eachRowLength = grid[0].length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            // 每一行的最大值，还得是每一列中的最大值
            // 直接排序进行操作
            Arrays.sort(grid[i]);
        }
        for (int j = 0; j < eachRowLength; j++) {
            int max = grid[0][j];
            for (int i = 0; i < length; i++) {
                // 找出每个下标中的最小值
                int temp = grid[i][j];
                max = Math.max(temp, max);
            }
            ans += max;
        }
        return ans;
    }

}
