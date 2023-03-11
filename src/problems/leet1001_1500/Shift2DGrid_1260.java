package problems.leet1001_1500;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author : Real
 * @ date : 2021/11/17 16:46
 * @ description : 1260. 二维网格迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * 每次「迁移」操作将会引发下述活动：
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 * <p>
 * 提示：
 * m ==grid.length
 * n ==grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shift-2d-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Shift2DGrid_1260 {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // 迁移次数应该取模
        k = k % (grid.length * grid[0].length);
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }

        // 将二维数组转移称为一维列表，之后进行原地转移
        for (int i = 0; i < k; i++) {
            int tempLast = list.get(m * n - 1);
            int temp = list.get(0);
            for (int j = 1; j < m * n; j++) {
                // 把前面的值迁移到后面一个，首先要保存
                Integer integer = list.get(j);
                list.set(j, temp);
                temp = integer;
            }
            list.set(0, tempLast);
        }

        int flag = 0;
        for (int i = 0; i < list.size() / n; i++) {
            List<Integer> tempList = new ArrayList<>();
            int loop = n;
            while (loop > 0) {
                tempList.add(list.get(flag++));
                loop--;
            }
            ans.add(tempList);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        List<List<Integer>> lists = shiftGrid(grid, k);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + "  ");
            }
        }
    }

}
